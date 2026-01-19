package com.learn.dsa.basic.graphs;
/**
 * 
 * @author karthik
 * Check if the graph is cycle or not
 * 
 *                          A
 *                          
 *                       B      C
 * 
 *      
 */

import java.util.*;

public class DirectedGraphCycleOrNotIMPORTANT {
	
	public static void main(String[] args)
    {
       
    }
	
	public static boolean isCycle(List<List<Integer>> graph, boolean[] visited, boolean rStack[], int source) {
		
		if(rStack[source]) return true;
		if(visited[source]) return false;
		
		rStack[source] = true;
		visited[source]= true;
		
		List<Integer> adjecent = graph.get(source);
		
		for(Integer adgjecent: adjecent) {
			
			return isCycle(graph, visited, rStack , adgjecent);
		}
		
		rStack[source]=false;
		
		return false;
		
	}
	
	public static boolean detectCycle(int v, int edges[][]) {
		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0;i<v;i++) {//Empty initialization
			graph.add(new ArrayList<>());
			
		}
		for(int i=0;i<edges.length;i++) {
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
		}
		boolean visited[] = new boolean[v];
		
		boolean rStack[] = new boolean[v];
		
		for(int i=0;i<v;i++) {
			if(visited[i]) {
				if(isCycle(graph, visited, rStack,i)) {
					return true;
				}
			}
		}
		return false;
	}

	
	

}
