package com.learn.dsa.basic.graphs;

import java.util.*;

public class DFS {

	 // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Get the number of vertices in the graph.
        int V = adj.size(); 

        // Create an ArrayList to store the DFS traversal order.
        ArrayList<Integer> dfsTraversal = new ArrayList<>(); 

        // Create a boolean array to keep track of visited vertices.
        // The size is V because vertices are 0-indexed.
        boolean[] visited = new boolean[V]; 

        // Start the DFS traversal from vertex 0.
        // We assume the graph is connected, so starting from 0 will visit all vertices.
        dfsUtil(0, adj, visited, dfsTraversal); 

        return dfsTraversal; // Return the list of visited vertices in DFS order.
    }

    // Recursive helper function for DFS traversal.
    private void dfsUtil(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfsTraversal) {
        // Mark the current vertex as visited.
        visited[vertex] = true; 

        // Add the current vertex to the traversal list.
        dfsTraversal.add(vertex); 

        // Iterate through all neighbors of the current vertex.
        // The order of iteration matters to match the problem's "left to right" requirement.
        for (int neighbor : adj.get(vertex)) {
            // If a neighbor has not been visited, recursively call dfsUtil on it.
            if (!visited[neighbor]) {
                dfsUtil(neighbor, adj, visited, dfsTraversal); 
            }
        }
    }
} // Remove the closing brace that corresponds to the redundant outer class

