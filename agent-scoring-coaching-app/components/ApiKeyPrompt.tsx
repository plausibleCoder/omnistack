import React, { useState } from 'react';

interface ApiKeyPromptProps {
  onApiKeySubmit: (apiKey: string) => void;
}

const ApiKeyPrompt: React.FC<ApiKeyPromptProps> = ({ onApiKeySubmit }) => {
  const [apiKey, setApiKey] = useState('');

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (apiKey.trim()) {
      onApiKeySubmit(apiKey.trim());
    }
  };

  return (
    <div className="text-center text-gray-600 p-4">
      <svg xmlns="http://www.w3.org/2000/svg" className="mx-auto h-12 w-12 text-brand-secondary" fill="none" viewBox="0 0 24 24" stroke="currentColor" strokeWidth="1.5">
        <path strokeLinecap="round" strokeLinejoin="round" d="M15.75 5.25a3 3 0 013 3m3 0a6 6 0 01-7.029 5.912c-.563-.097-1.159.026-1.563.43L10.5 17.25H8.25v2.25H6v2.25H2.25v-2.818c0-.597.237-1.17.659-1.591l6.499-6.499c.404-.404.527-1 .43-1.563A6 6 0 1121.75 8.25z" />
      </svg>
      <h3 className="mt-4 text-lg font-semibold text-brand-dark">Enter Your API Key</h3>
      <p className="mt-2 text-sm text-gray-500">
        To analyze transcripts, please enter your Google Gemini API key below.
      </p>
      <p className="mt-1 text-sm text-gray-500">
        For more information on billing, please visit the{' '}
        <a href="https://ai.google.dev/gemini-api/docs/billing" target="_blank" rel="noopener noreferrer" className="text-brand-secondary hover:underline font-medium">
          official documentation
        </a>.
      </p>
      <form onSubmit={handleSubmit} className="mt-6 flex flex-col items-center gap-4 w-full">
        <input
          type="password"
          value={apiKey}
          onChange={(e) => setApiKey(e.target.value)}
          placeholder="Enter your Gemini API Key"
          className="w-full max-w-sm p-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-brand-secondary focus:border-brand-secondary transition duration-150 ease-in-out"
          aria-label="Gemini API Key"
        />
        <button
          type="submit"
          disabled={!apiKey.trim()}
          className="w-full max-w-sm bg-brand-secondary text-white font-bold py-2 px-6 rounded-lg hover:bg-brand-primary focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-brand-secondary disabled:bg-gray-400 disabled:cursor-not-allowed transition-colors duration-300"
        >
          Save and Continue
        </button>
      </form>
    </div>
  );
};

export default ApiKeyPrompt;