import { GoogleGenAI, Type } from "@google/genai";
import { AnalysisResult } from '../types';

const analysisSchema = {
  type: Type.OBJECT,
  properties: {
    agent_name: { type: Type.STRING, description: "The name of the agent in the transcript." },
    overall_score: { type: Type.NUMBER, description: "A single overall performance score from 1 to 10, calculated as the average of the KPI scores." },
    summary: { type: Type.STRING, description: "A brief, one to two-sentence summary of the agent's performance and the call's outcome." },
    kpi_scores: {
      type: Type.OBJECT,
      properties: {
        problem_resolution: { type: Type.INTEGER, description: "Score from 1-10. Did the agent solve the customer's issue?" },
        empathy_and_tone: { type: Type.INTEGER, description: "Score from 1-10. Was the agent polite, empathetic, and professional?" },
        efficiency: { type: Type.INTEGER, description: "Score from 1-10. Was the call timely and not rushed?" },
        compliance_and_adherence: { type: Type.INTEGER, description: "Score from 1-10. Did the agent follow required procedures (e.g., greeting, verification)?" },
        upsell_opportunity: { type: Type.INTEGER, description: "Score from 1-10. Did the agent identify and act on upsell or retention opportunities?" },
      },
      required: ["problem_resolution", "empathy_and_tone", "efficiency", "compliance_and_adherence", "upsell_opportunity"]
    },
    feedback: {
      type: Type.OBJECT,
      properties: {
        strengths: { type: Type.STRING, description: "Qualitative feedback on what the agent did well." },
        areas_for_improvement: { type: Type.STRING, description: "Qualitative feedback on what the agent could improve." },
      },
      required: ["strengths", "areas_for_improvement"]
    },
    coaching_tip: { type: Type.STRING, description: "A single, specific, and actionable coaching tip for the agent to improve." },
  },
  required: ["agent_name", "overall_score", "summary", "kpi_scores", "feedback", "coaching_tip"]
};


export const analyzeTranscript = async (transcript: string, apiKey: string): Promise<AnalysisResult> => {
  if (!apiKey) {
    throw new Error("API Key is not provided. Please enter your API key.");
  }
  const ai = new GoogleGenAI({ apiKey });

  const prompt = `
    Analyze the following customer service call transcript. Evaluate the agent's performance based on the provided Key Performance Indicators (KPIs). 
    Each KPI should be scored on a scale of 1 to 10.
    Based on your analysis, provide a summary, scores for each KPI, qualitative feedback (strengths and areas for improvement), and a single actionable coaching tip.
    The agent's name should be extracted from the transcript.
    The overall score should be the average of the five KPI scores, rounded to one decimal place.

    Transcript:
    ---
    ${transcript}
    ---
    
    Please provide the output in the structured JSON format defined by the schema.
  `;

  try {
    const response = await ai.models.generateContent({
      model: 'gemini-2.5-flash',
      contents: prompt,
      config: {
        responseMimeType: 'application/json',
        responseSchema: analysisSchema,
        temperature: 0.2,
      }
    });

    const jsonText = response.text;
    const result = JSON.parse(jsonText);

    // Validate if the parsed object matches the expected structure.
    if (
      !result.agent_name ||
      typeof result.overall_score !== 'number' ||
      !result.summary ||
      !result.kpi_scores ||
      !result.feedback ||
      !result.coaching_tip
    ) {
      throw new Error("Received malformed JSON data from API.");
    }

    return result as AnalysisResult;

  } catch (error) {
    console.error("Error calling Gemini API:", error);
    // Re-throw the original error so the UI component can display a specific message.
    if (error instanceof Error) {
        throw error;
    }
    throw new Error("An unknown error occurred while analyzing the transcript.");
  }
};