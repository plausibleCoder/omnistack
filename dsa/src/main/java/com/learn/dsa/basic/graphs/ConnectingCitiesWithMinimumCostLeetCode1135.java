package com.learn.dsa.basic.graphs;
/**
 * 24th August 2025
 * 
 * @author karthik
 *You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

 

Example 1:


Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation: 

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18
 

Constraints:

1 <= points.length <= 1000
-106 <= xi, yi <= 106
All pairs (xi, yi) are distinct.
 */
import java.util.*;
public class ConnectingCitiesWithMinimumCostLeetCode1135 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectingCitiesWithMinimumCostLeetCode1135 solution = new ConnectingCitiesWithMinimumCostLeetCode1135();

        // Example 1
        int[][] points1 = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println("Min cost for Example 1: " + solution.minCostConnectPoints(points1)); // Expected: 20

        // Example 2
        int[][] points2 = {{3, 12}, {-2, 5}, {-4, 1}};
        System.out.println("Min cost for Example 2: " + solution.minCostConnectPoints(points2)); // Expected: 18

        // Example 3
        int[][] points3 = {{0, 0}, {1, 1}, {1, 0}, {-1, 1}};
        System.out.println("Min cost for Example 3: " + solution.minCostConnectPoints(points3)); // Expected: 4
   

	}

	static class Edge {
        int toPoint;
        int cost;

        public Edge(int toPoint, int cost) {
            this.toPoint = toPoint;
            this.cost = cost;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int numPoints = points.length;
        if (numPoints <= 1) { // Base case: If there's 0 or 1 point, no cost is needed
            return 0;
        }

        // Min-heap (PriorityQueue) to store edges, prioritized by cost
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.cost));

        // Set to keep track of visited points (points included in the MST)
        Set<Integer> visited = new HashSet<>();

        int minCost = 0;
        int edgesCount = 0;

        // Start Prim's algorithm from the first point (index 0)
        // Add all edges from point 0 to other points to the priority queue
        // with their respective Manhattan distances as costs.
        // We push (cost, destination_point_index) pairs into the PQ.
        for (int i = 1; i < numPoints; i++) {
            int cost = calculateManhattanDistance(points, 0, i);
            pq.offer(new Edge(i, cost));
        }
        visited.add(0); // Mark the starting point as visited

        // Continue until all points are visited or the PQ is empty
        while (!pq.isEmpty() && edgesCount < numPoints - 1) {
            Edge currentEdge = pq.poll(); // Get the edge with the minimum cost
            int currentPoint = currentEdge.toPoint;
            int costToConnect = currentEdge.cost;

            // If the point has already been visited, skip it (this prevents cycles)
            if (visited.contains(currentPoint)) {
                continue;
            }

            // Mark the point as visited and add its cost to the total
            visited.add(currentPoint);
            minCost += costToConnect;
            edgesCount++;

            // For the newly added point, add all its unvisited neighbors' edges to the PQ
            for (int nextPoint = 0; nextPoint < numPoints; nextPoint++) {
                if (!visited.contains(nextPoint)) {
                    int cost = calculateManhattanDistance(points, currentPoint, nextPoint);
                    pq.offer(new Edge(nextPoint, cost));
                }
            }
        }

        return minCost; // Return the total minimum cost
    }

    // Helper function to calculate Manhattan distance
    private int calculateManhattanDistance(int[][] points, int p1Index, int p2Index) {
        return Math.abs(points[p1Index][0] - points[p2Index][0]) +
               Math.abs(points[p1Index][1] - points[p2Index][1]);
    }



}
