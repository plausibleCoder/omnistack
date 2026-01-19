import React from 'react';

interface TranscriptInputProps {
  transcript: string;
  onTranscriptChange: (value: string) => void;
  onAnalyze: () => void;
  isLoading: boolean;
  hasApiKey: boolean;
  isComparisonMode: boolean;
  onComparisonModeChange: (value: boolean) => void;
}

const TranscriptInput: React.FC<TranscriptInputProps> = ({
  transcript,
  onTranscriptChange,
  onAnalyze,
  isLoading,
  hasApiKey,
  isComparisonMode,
  onComparisonModeChange,
}) => {
  return (
    <div className="bg-white rounded-2xl shadow-lg p-6 border border-gray-200">
      <h2 className="text-xl font-semibold text-brand-dark mb-4">Call Transcript</h2>
      <p className="text-sm text-gray-500 mb-4">
        Paste the raw call transcript below. You can use the pre-filled sample or your own data.
      </p>
      <textarea
        value={transcript}
        onChange={(e) => onTranscriptChange(e.target.value)}
        placeholder="Paste call transcript here..."
        className="w-full h-96 p-4 border border-gray-300 rounded-lg focus:ring-2 focus:ring-brand-secondary focus:border-brand-secondary transition duration-150 ease-in-out text-sm"
        disabled={isLoading}
      />
      
      <div className="flex items-center justify-center my-4">
        <label htmlFor="comparison-toggle" className="mr-3 text-sm font-medium text-gray-700 cursor-pointer">
          Compare with Classical NLP
        </label>
        <div className="relative inline-block w-10 mr-2 align-middle select-none transition duration-200 ease-in">
          <input
            type="checkbox"
            id="comparison-toggle"
            checked={isComparisonMode}
            onChange={(e) => onComparisonModeChange(e.target.checked)}
            className="toggle-checkbox absolute block w-6 h-6 rounded-full bg-white border-4 appearance-none cursor-pointer"
            disabled={isLoading}
          />
          <label htmlFor="comparison-toggle" className="toggle-label block overflow-hidden h-6 rounded-full bg-gray-300 cursor-pointer"></label>
        </div>
        <style>{`
          .toggle-checkbox:checked {
            right: 0;
            border-color: #3b82f6; /* brand-secondary */
          }
          .toggle-checkbox:checked + .toggle-label {
            background-color: #3b82f6; /* brand-secondary */
          }
        `}</style>
      </div>

      <button
        onClick={onAnalyze}
        disabled={isLoading || !hasApiKey}
        title={!hasApiKey ? "Please enter an API key first" : ""}
        className="w-full bg-brand-secondary text-white font-bold py-3 px-4 rounded-lg hover:bg-brand-primary focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-brand-secondary disabled:bg-gray-400 disabled:cursor-not-allowed transition-colors duration-300 flex items-center justify-center"
      >
        {isLoading ? (
          <>
            <svg className="animate-spin -ml-1 mr-3 h-5 w-5 text-white" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
              <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4"></circle>
              <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"></path>
            </svg>
            Analyzing...
          </>
        ) : (
          isComparisonMode ? 'Run Comparison' : 'Analyze Transcript'
        )}
      </button>
    </div>
  );
};

export default TranscriptInput;