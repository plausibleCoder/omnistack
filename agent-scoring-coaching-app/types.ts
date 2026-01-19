
export interface KpiScores {
  problem_resolution: number;
  empathy_and_tone: number;
  efficiency: number;
  compliance_and_adherence: number;
  upsell_opportunity: number;
}

export interface Feedback {
  strengths: string;
  areas_for_improvement: string;
}

export interface AnalysisResult {
  agent_name: string;
  overall_score: number;
  summary: string;
  kpi_scores: KpiScores;
  feedback: Feedback;
  coaching_tip: string;
}
