package com.learn.dsa.basic.graphs;
/**
 * August 24th 2025
 * @author karthik
 *You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given an array relations where relations[i] = [prevCoursei, nextCoursei], representing a prerequisite relationship between course prevCoursei and course nextCoursei: course prevCoursei has to be taken before course nextCoursei.

In one semester, you can take any number of courses as long as you have taken all the prerequisites in the previous semester for the courses you are taking.

Return the minimum number of semesters needed to take all courses. If there is no way to take all the courses, return -1.

 

Example 1:



Input: n = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation: The figure above represents the given graph.
In the first semester, you can take courses 1 and 2.
In the second semester, you can take course 3.
Example 2:



Input: n = 3, relations = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: No course can be studied because they are prerequisites of each other.
 

Constraints:

1 <= n <= 5000
1 <= relations.length <= 5000
relations[i].length == 2
1 <= prevCoursei, nextCoursei <= n
prevCoursei != nextCoursei
All the pairs [prevCoursei, nextCoursei] are unique.
 */

import java.util.*;
public class MinimumSemestersLeetCode1136 {

	public static void main(String[] args) {
		MinimumSemestersLeetCode1136 solution = new MinimumSemestersLeetCode1136();

        // --- Test case 1: Multiple semesters required, no cycle ---
        // Courses: 1, 2, 3
        // Prerequisites: [1, 3], [2, 3]
        // Explanation: In semester 1, courses 1 and 2 can be taken.
        //              In semester 2, course 3 can be taken.
        int n1 = 3;
        int[][] relations1 = {{1, 3}, {2, 3}};
        System.out.println("Test case 1: No cycle, multiple semesters");
        int result1 = solution.minimumSemesters(n1, relations1);
        System.out.println("Result: " + result1); // Expected: 2
        System.out.println("---");

        // --- Test case 2: Cycle exists, impossible to complete ---
        // Courses: 1, 2, 3
        // Prerequisites: [1, 2], [2, 3], [3, 1]
        // Explanation: A circular dependency: 1 -> 2 -> 3 -> 1.
        int n2 = 3;
        int[][] relations2 = {{1, 2}, {2, 3}, {3, 1}};
        System.out.println("Test case 2: Cycle exists");
        int result2 = solution.minimumSemesters(n2, relations2);
        System.out.println("Result: " + result2); // Expected: -1
        System.out.println("---");

        // --- Test case 3: Courses with no prerequisites, already complete ---
        // Courses: 1, 2
        // Prerequisites: None
        // Explanation: Courses 1 and 2 can be taken in the first semester.
        int n3 = 2;
        int[][] relations3 = {};
        System.out.println("Test case 3: No prerequisites");
        int result3 = solution.minimumSemesters(n3, relations3);
        System.out.println("Result: " + result3); // Expected: 1
        System.out.println("---");

        // --- Test case 4: Complex dependencies ---
        // Courses: 1, 2, 3, 4
        // Prerequisites: [1, 2], [1, 3], [2, 4], [3, 4]
        // Explanation: Semester 1: Course 1. Semester 2: Courses 2 and 3. Semester 3: Course 4.
        int n4 = 4;
        int[][] relations4 = {{1, 2}, {1, 3}, {2, 4}, {3, 4}};
        System.out.println("Test case 4: Complex dependencies");
        int result4 = solution.minimumSemesters(n4, relations4);
        System.out.println("Result: " + result4); // Expected: 3
        System.out.println("---");

        // --- Test case 5: A simple, linear dependency chain ---
        // Courses: 1, 2, 3, 4
        // Prerequisites: [1, 2], [2, 3], [3, 4]
        // Explanation: Semester 1: Course 1. Semester 2: Course 2. Semester 3: Course 3. Semester 4: Course 4.
        int n5 = 4;
        int[][] relations5 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println("Test case 5: Linear dependency chain");
        int result5 = solution.minimumSemesters(n5, relations5);
        System.out.println("Result: " + result5); // Expected: 4
        System.out.println("---");

	}

	  public int minimumSemesters(int n, int[][] relations) {
	        // 1. Build the graph and calculate in-degrees
	        Map<Integer, List<Integer>> graph = new HashMap<>();
	        int[] inDegree = new int[n + 1];

	        for (int[] relation : relations) {
	            int prev = relation[0];
	            int next = relation[1];
	            graph.computeIfAbsent(prev, k -> new ArrayList<>()).add(next);
	            inDegree[next]++;
	        }

	        // 2. Initialize queue with courses having no prerequisites
	        Queue<Integer> queue = new LinkedList<>();
	        for (int i = 1; i <= n; i++) {
	            if (inDegree[i] == 0) {
	                queue.add(i);
	            }
	        }

	        int semesters = 0;
	        int coursesTaken = 0;

	        // 3. Process courses level by level (BFS)
	        while (!queue.isEmpty()) {
	            semesters++;
	            int levelSize = queue.size();
	            for (int i = 0; i < levelSize; i++) {
	                int course = queue.poll();
	                coursesTaken++;

	                if (graph.containsKey(course)) {
	                    for (int nextCourse : graph.get(course)) {
	                        inDegree[nextCourse]--;
	                        if (inDegree[nextCourse] == 0) {
	                            queue.add(nextCourse);
	                        }
	                    }
	                }
	            }
	        }

	        // 4. Check for cycles and return result
	        if (coursesTaken == n) {
	            return semesters;
	        } else {
	            return -1;
	        }
	    }
}
