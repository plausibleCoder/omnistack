package com.learn.dsa.basic.graphs;
/**
 * 
 * @author karthik
 * 
 * Adjacency Matrix 
 * Representation:
 * 
 * int graph [][] = new int[n][n]
 * edges =[[A,B],[A,C],[C,D],[A,D]]
 * for(int=0; i<edges.length;i++){
 * 
 *   graph[edges[i][0]][edges[i][1]]=1;
 *   graph[edges[i][1]][edges[i][0]]=1;
 *   
 * }
 * 
 * Adjacency List
 * representation 1
 * 
 * List<List<Integer>>graph = new ArrayList<>();
 *  * for(int i=0;i<v;i++){  // v is vertex ; vertex is different from edges
 * 
 *   graph.add(new ArrayList<>());
 * }
 * 
 * representation 2
 * 
 * Map<Integer, List<Integer>>graph = new HashMap<>(); //Integer is city name, we can go with String or character List<Integer> is the edges
 * 

 * 
 * for(int i=0;i<v;i++){
 * 
 * graph.put(i, new ArrayList<>());
 * 
 *}
 *
 *connecting the edges 
 *for(int i=0; i<edge.length; i++){
 *  graph.get(edges[i][0]).add(edges[i][1]);
 *  graph.get(edges[i][1]).add(edges[i][0]);
 *}	
 *
 *
 *BFS: Lotus - It checks all the surroundings -- Shortest answer, this is the best
 *DFS: 
 *
 *Indegree and outdegree 
 *
 *
 */
public class BasicOfGraphsAbhishek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
