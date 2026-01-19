
import React from 'react';

interface ErrorMessageProps {
  message: string;
}

const ErrorMessage: React.FC<ErrorMessageProps> = ({ message }) => {
  return (
    <div className="bg-red-50 text-red-700 border border-red-200 rounded-lg p-4 text-center">
       <h3 className="font-bold">An Error Occurred</h3>
       <p className="text-sm mt-1">{message}</p>
    </div>
  );
};

export default ErrorMessage;
