import { AnalysisResult } from '../types';

export const analyzeTranscriptClassical = async (transcript: string): Promise<AnalysisResult> => {
  try {
    const response = await fetch('http://localhost:5001/analyze', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ transcript }),
    });

    if (!response.ok) {
      const errorData = await response.json().catch(() => ({ message: response.statusText }));
      throw new Error(`Classical NLP service failed: ${errorData.message || response.statusText}`);
    }

    const result: AnalysisResult = await response.json();
    
    // Basic validation to ensure the response shape is correct
    if (
      !result.agent_name ||
      typeof result.overall_score !== 'number' ||
      !result.summary ||
      !result.kpi_scores ||
      !result.feedback ||
      !result.coaching_tip
    ) {
      throw new Error("Received malformed JSON data from Classical NLP API.");
    }
    
    return result;
  } catch (error) {
    console.error("Error calling Classical NLP API:", error);
    if (error instanceof Error) {
        // Re-throw specific errors to be handled by the UI
        throw error;
    }
    throw new Error("An unknown error occurred while analyzing the transcript with the classical NLP model.");
  }
};
