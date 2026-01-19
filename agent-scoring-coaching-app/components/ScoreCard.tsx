
import React from 'react';

interface ScoreCardProps {
  title: string;
  score: number;
}

const ScoreCard: React.FC<ScoreCardProps> = ({ title, score }) => {
  const getScoreColorClasses = () => {
    if (score >= 8) {
      return 'border-green-500 text-green-600';
    }
    if (score >= 5) {
      return 'border-yellow-500 text-yellow-600';
    }
    return 'border-red-500 text-red-600';
  };

  return (
    <div className="bg-gray-50 p-3 rounded-lg border border-gray-200">
      <div className={`mx-auto w-16 h-16 rounded-full border-4 ${getScoreColorClasses()} flex items-center justify-center`}>
        <span className="text-2xl font-bold">{score}</span>
      </div>
      <p className="text-xs font-medium text-gray-600 mt-2">{title}</p>
    </div>
  );
};

export default ScoreCard;
