
import React, { useState } from 'react';
import { AnalysisResult } from '../types';
import ScoreCard from './ScoreCard';

interface AnalysisReportProps {
  result: AnalysisResult;
}

const AnalysisReport: React.FC<AnalysisReportProps> = ({ result }) => {
  const [showJson, setShowJson] = useState(false);

  const handleCopyJson = () => {
    navigator.clipboard.writeText(JSON.stringify(result, null, 2));
    alert('JSON copied to clipboard!');
  };

  const getScoreColor = (score: number) => {
    if (score >= 8) return 'bg-green-100 text-green-800';
    if (score >= 5) return 'bg-yellow-100 text-yellow-800';
    return 'bg-red-100 text-red-800';
  };

  return (
    <div className="animate-fade-in space-y-6">
      <div>
        <div className="flex justify-between items-start">
          <div>
            <h2 className="text-2xl font-bold text-brand-primary">Analysis for {result.agent_name}</h2>
            <p className="text-gray-600 mt-1">{result.summary}</p>
          </div>
          <div className="text-center ml-4 flex-shrink-0">
             <p className="text-sm text-gray-500">Overall</p>
             <p className={`text-4xl font-bold ${getScoreColor(result.overall_score).split(' ')[1]}`}>{result.overall_score.toFixed(1)}</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-5 gap-4 text-center">
        <ScoreCard title="Resolution" score={result.kpi_scores.problem_resolution} />
        <ScoreCard title="Empathy" score={result.kpi_scores.empathy_and_tone} />
        <ScoreCard title="Efficiency" score={result.kpi_scores.efficiency} />
        <ScoreCard title="Compliance" score={result.kpi_scores.compliance_and_adherence} />
        <ScoreCard title="Upsell" score={result.kpi_scores.upsell_opportunity} />
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        <div className="bg-green-50 p-4 rounded-lg border border-green-200">
          <h4 className="font-semibold text-green-800">Strengths</h4>
          <p className="text-sm text-green-700 mt-1">{result.feedback.strengths}</p>
        </div>
        <div className="bg-yellow-50 p-4 rounded-lg border border-yellow-200">
          <h4 className="font-semibold text-yellow-800">Areas for Improvement</h4>
          <p className="text-sm text-yellow-700 mt-1">{result.feedback.areas_for_improvement}</p>
        </div>
      </div>
      
      <div className="bg-brand-light p-4 rounded-lg border border-blue-200">
        <h4 className="font-semibold text-brand-primary">Actionable Coaching Tip</h4>
        <p className="text-sm text-brand-dark mt-1">{result.coaching_tip}</p>
      </div>

      <div>
        <button onClick={() => setShowJson(!showJson)} className="text-sm text-brand-secondary hover:underline">
          {showJson ? 'Hide' : 'Show'} Salesforce-Ready JSON
        </button>
        {showJson && (
          <div className="relative mt-2">
            <pre className="bg-gray-800 text-white p-4 rounded-lg text-xs overflow-x-auto">
              <code>{JSON.stringify(result, null, 2)}</code>
            </pre>
            <button
              onClick={handleCopyJson}
              className="absolute top-2 right-2 bg-gray-600 hover:bg-gray-500 text-white text-xs font-bold py-1 px-2 rounded"
            >
              Copy
            </button>
          </div>
        )}
      </div>
    </div>
  );
};

export default AnalysisReport;
