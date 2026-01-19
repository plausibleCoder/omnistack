import React, { useState, useCallback, useEffect } from 'react';
import { AnalysisResult } from './types';
import { analyzeTranscript } from './services/geminiService';
import { analyzeTranscriptClassical } from './services/classicalNlpService';
import { sampleTranscript } from './constants';
import Header from './components/Header';
import TranscriptInput from './components/TranscriptInput';
import AnalysisReport from './components/AnalysisReport';
import Loader from './components/Loader';
import ErrorMessage from './components/ErrorMessage';
import ApiKeyPrompt from './components/ApiKeyPrompt';

const API_KEY_STORAGE_KEY = 'gemini_api_key';

const App: React.FC = () => {
  const [transcript, setTranscript] = useState<string>(sampleTranscript);
  const [geminiResult, setGeminiResult] = useState<AnalysisResult | null>(null);
  const [classicalResult, setClassicalResult] = useState<AnalysisResult | null>(null);
  const [isComparisonMode, setIsComparisonMode] = useState<boolean>(false);
  const [isLoading, setIsLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);
  const [apiKey, setApiKey] = useState<string | null>(() => localStorage.getItem(API_KEY_STORAGE_KEY));

  const handleApiKeySubmit = (newApiKey: string) => {
    localStorage.setItem(API_KEY_STORAGE_KEY, newApiKey);
    setApiKey(newApiKey);
    setError(null); // Clear previous errors on new key submission
  };

  const handleAnalyze = useCallback(async () => {
    if (!apiKey) {
      setError("Please enter your API key before analyzing.");
      return;
    }
    if (!transcript.trim()) {
      setError("Transcript cannot be empty.");
      return;
    }
    setIsLoading(true);
    setError(null);
    setGeminiResult(null);
    setClassicalResult(null);

    try {
      if (isComparisonMode) {
        const [geminiRes, classicalRes] = await Promise.all([
          analyzeTranscript(transcript, apiKey),
          analyzeTranscriptClassical(transcript)
        ]);
        setGeminiResult(geminiRes);
        setClassicalResult(classicalRes);
      } else {
        const result = await analyzeTranscript(transcript, apiKey);
        setGeminiResult(result);
      }
    } catch (e) {
      const errorMessage = e instanceof Error ? e.message : "An unknown error occurred.";
      // Check for common API key-related error messages
      if (errorMessage.includes("API key not valid") || errorMessage.includes("API_KEY") || errorMessage.includes("Requested entity was not found")) {
        localStorage.removeItem(API_KEY_STORAGE_KEY);
        setApiKey(null);
        setError("Your API key appears to be invalid. Please enter a valid API key and try again.");
      } else {
        setError(`Failed to analyze transcript: ${errorMessage}`);
      }
      console.error(e);
    } finally {
      setIsLoading(false);
    }
  }, [transcript, apiKey, isComparisonMode]);
  
  const renderRightPanel = () => {
    if (isLoading) {
      return <Loader />;
    }
    
    // If there's no API key, we must prompt for it.
    if (!apiKey) {
      return (
        <>
          <ApiKeyPrompt onApiKeySubmit={handleApiKeySubmit} />
          {/* Show an error message if a previous attempt failed */}
          {error && <div className="mt-4"><ErrorMessage message={error}/></div>}
        </>
      );
    }

    // If there's a general error from analysis, show it.
    if (error) {
        return <ErrorMessage message={error} />;
    }

    if (isComparisonMode && geminiResult && classicalResult) {
      return (
        <div className="grid grid-cols-1 md:grid-cols-2 gap-6 w-full">
          <div>
            <h3 className="text-lg font-bold text-center mb-4 text-brand-primary">Gemini 2.5 Flash Analysis</h3>
            <AnalysisReport result={geminiResult} />
          </div>
          <div>
            <h3 className="text-lg font-bold text-center mb-4 text-brand-dark">Classical NLP Analysis</h3>
            <AnalysisReport result={classicalResult} />
          </div>
        </div>
      );
    }

    if (geminiResult) {
      return <AnalysisReport result={geminiResult} />;
    }
    
    // Initial state after key is provided
    return (
      <div className="text-center text-gray-500">
        <svg xmlns="http://www.w3.org/2000/svg" className="mx-auto h-12 w-12 text-gray-400" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M9 12h6m-6 4h6m2 5H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z" />
        </svg>
        <h3 className="mt-2 text-sm font-medium text-gray-900">Analysis Report</h3>
        <p className="mt-1 text-sm text-gray-500">Your agent's performance report will appear here.</p>
      </div>
    );
  };


  return (
    <div className="min-h-screen bg-gray-50 text-gray-800 font-sans">
      <Header />
      <main className="p-4 sm:p-6 lg:p-8 max-w-7xl mx-auto">
        <div className="grid grid-cols-1 lg:grid-cols-2 gap-8">
          <TranscriptInput
            transcript={transcript}
            onTranscriptChange={setTranscript}
            onAnalyze={handleAnalyze}
            isLoading={isLoading}
            hasApiKey={!!apiKey}
            isComparisonMode={isComparisonMode}
            onComparisonModeChange={setIsComparisonMode}
          />
          <div className={`lg:col-span-1 bg-white rounded-2xl shadow-lg p-6 border border-gray-200 min-h-[500px] flex flex-col justify-center ${isComparisonMode && (geminiResult || classicalResult) ? 'items-start' : 'items-center'}`}>
            {renderRightPanel()}
          </div>
        </div>
      </main>
    </div>
  );
};

export default App;