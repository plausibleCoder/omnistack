package com.learn.dsa.basic.heaps;

import java.util.*;

public class IPOLeetCode502 {

    // Inner static class to represent a Project
    static class Project {
        int capital;
        int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }

        // Sort projects by capital required
        // This helps us efficiently add projects to the maxProfitHeap as our capital grows
        Arrays.sort(projects, (a, b) -> a.capital - b.capital);

        // Min-heap for projects we cannot afford yet (ordered by capital)
        // These are projects that require more capital than we currently have.
        PriorityQueue<Project> minCapitalHeap = new PriorityQueue<>((a, b) -> a.capital - b.capital);

        // Max-heap for projects we can afford (ordered by profit)
        // These are projects we can start right now, and we want to pick the most profitable.
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);

        int projectIndex = 0; // Pointer to the next project to consider from the sorted 'projects' array

        // We want to complete at most 'k' projects
        for (int i = 0; i < k; i++) {
            // Add all projects that we can currently afford to the maxProfitHeap
            // We iterate through the sorted 'projects' array.
            while (projectIndex < n && projects[projectIndex].capital <= w) {
                maxProfitHeap.offer(projects[projectIndex].profit);
                projectIndex++;
            }

            // If the maxProfitHeap is empty, it means we cannot afford any more projects,
            // so we break out of the loop as we can't do any more.
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // Select the most profitable project from the ones we can afford
            // and add its profit to our current capital 'w'.
            w += maxProfitHeap.poll();
        }

        return w; // Return the final maximized capital
    }

    public static void main(String[] args) {
    	IPOLeetCode502 solver = new IPOLeetCode502();

        // Test Case 1: Example from LeetCode
        int k1 = 2;
        int w1 = 0;
        int[] profits1 = {1, 2, 3};
        int[] capital1 = {0, 1, 1};
        // Expected Output: 4 (Initial W=0. Pick project 0 (profit 1, capital 0). W=1.
        // Can now pick project 1 (profit 2, capital 1) or project 2 (profit 3, capital 1).
        // Pick project 2. W=1+3=4)
        System.out.println("Test Case 1:");
        System.out.println("k = " + k1 + ", w = " + w1 + ", profits = " + Arrays.toString(profits1) + ", capital = " + Arrays.toString(capital1));
        System.out.println("Maximized Capital: " + solver.findMaximizedCapital(k1, w1, profits1, capital1));
        System.out.println("---");

        // Test Case 2: Another example
        int k2 = 3;
        int w2 = 0;
        int[] profits2 = {1, 2, 3};
        int[] capital2 = {0, 1, 2};
        // Expected Output: 6 (Initial W=0. Pick project 0 (profit 1, capital 0). W=1.
        // Can now pick project 1 (profit 2, capital 1). W=3.
        // Can now pick project 2 (profit 3, capital 2). W=6)
        System.out.println("Test Case 2:");
        System.out.println("k = " + k2 + ", w = " + w2 + ", profits = " + Arrays.toString(profits2) + ", capital = " + Arrays.toString(capital2));
        System.out.println("Maximized Capital: " + solver.findMaximizedCapital(k2, w2, profits2, capital2));
        System.out.println("---");

        // Test Case 3: Initial capital allows for some projects
        int k3 = 2;
        int w3 = 1;
        int[] profits3 = {10, 20, 5};
        int[] capital3 = {1, 2, 0};
        // Expected Output: 31 (Initial W=1. Projects: (1,10), (2,20), (0,5).
        // Round 1: Can afford (0,5) and (1,10). Pick (0,5). W=1+5=6.
        // Round 2: Can afford (1,10), (2,20). Pick (2,20). W=6+20=26.
        System.out.println("Test Case 3:");
        System.out.println("k = " + k3 + ", w = " + w3 + ", profits = " + Arrays.toString(profits3) + ", capital = " + Arrays.toString(capital3));
        System.out.println("Maximized Capital: " + solver.findMaximizedCapital(k3, w3, profits3, capital3));
        System.out.println("---");

        // Test Case 4: Cannot afford any projects initially
        int k4 = 1;
        int w4 = 0;
        int[] profits4 = {100};
        int[] capital4 = {5};
        // Expected Output: 0 (Cannot afford the only project)
        System.out.println("Test Case 4:");
        System.out.println("k = " + k4 + ", w = " + w4 + ", profits = " + Arrays.toString(profits4) + ", capital = " + Arrays.toString(capital4));
        System.out.println("Maximized Capital: " + solver.findMaximizedCapital(k4, w4, profits4, capital4));
        System.out.println("---");

        // Test Case 5: More projects than k, with varying capitals
        int k5 = 2;
        int w5 = 2;
        int[] profits5 = {1, 2, 3, 4};
        int[] capital5 = {0, 1, 2, 3};
        // Expected Output: 9
        // (Initial W=2. Projects: (0,1), (1,2), (2,3), (3,4).
        // Round 1: Can afford (0,1), (1,2), (2,3). Pick (2,3). W=2+3=5.
        // Round 2: Can afford (0,1), (1,2), (3,4). Pick (3,4). W=5+4=9.)
        System.out.println("Test Case 5:");
        System.out.println("k = " + k5 + ", w = " + w5 + ", profits = " + Arrays.toString(profits5) + ", capital = " + Arrays.toString(capital5));
        System.out.println("Maximized Capital: " + solver.findMaximizedCapital(k5, w5, profits5, capital5));
        System.out.println("---");

        // Test Case 6: No projects
        int k6 = 1;
        int w6 = 0;
        int[] profits6 = {};
        int[] capital6 = {};
        // Expected Output: 0
        System.out.println("Test Case 6:");
        System.out.println("k = " + k6 + ", w = " + w6 + ", profits = " + Arrays.toString(profits6) + ", capital = " + Arrays.toString(capital6));
        System.out.println("Maximized Capital: " + solver.findMaximizedCapital(k6, w6, profits6, capital6));
        System.out.println("---");
    }
}
