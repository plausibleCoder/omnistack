package com.learn.dsa.basic.graphs;
/*
 * A series of highways connect n cities numbered from 0 to n - 1. You are given a 2D integer array highways where highways[i] = [city1i, city2i, tolli] indicates that there is a highway that connects city1i and city2i, allowing a car to go from city1i to city2i and vice versa for a cost of tolli.

You are also given an integer discounts which represents the number of discounts you have. You can use a discount to travel across the ith highway for a cost of tolli / 2 (integer division). Each discount may only be used once, and you can only use at most one discount per highway.

Return the minimum total cost to go from city 0 to city n - 1, or -1 if it is not possible to go from city 0 to city n - 1.

 

Example 1:


Input: n = 5, highways = [[0,1,4],[2,1,3],[1,4,11],[3,2,3],[3,4,2]], discounts = 1
Output: 9
Explanation:
Go from 0 to 1 for a cost of 4.
Go from 1 to 4 and use a discount for a cost of 11 / 2 = 5.
The minimum cost to go from 0 to 4 is 4 + 5 = 9.

Example 2:


Input: n = 4, highways = [[1,3,17],[1,2,7],[3,2,5],[0,1,6],[3,0,20]], discounts = 20
Output: 8
Explanation:
Go from 0 to 1 and use a discount for a cost of 6 / 2 = 3.
Go from 1 to 2 and use a discount for a cost of 7 / 2 = 3.
Go from 2 to 3 and use a discount for a cost of 5 / 2 = 2.
The minimum cost to go from 0 to 3 is 3 + 3 + 2 = 8.
Example 3:


Input: n = 4, highways = [[0,1,3],[2,3,2]], discounts = 0
Output: -1
Explanation:
It is impossible to go from 0 to 3 so return -1.

 

Constraints:

2 <= n <= 1000
1 <= highways.length <= 1000
highways[i].length == 3
0 <= city1i, city2i <= n - 1
city1i != city2i
0 <= tolli <= 105
0 <= discounts <= 500
There are no duplicate highways.
 */
import java.util.*;
public class MinimumCosttoReachCityWithDiscountsLeetCode2093 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumCosttoReachCityWithDiscountsLeetCode2093 solution = new MinimumCosttoReachCityWithDiscountsLeetCode2093();

	        // Example from LeetCode
	        int n1 = 5;
	        int[][] highways1 = {{0, 1, 4}, {1, 2, 3}, {2, 3, 2}, {3, 4, 1}};
	        int discounts1 = 1;
	        System.out.println("Result 1: " + solution.minimumCost(n1, highways1, discounts1)); // Expected: 10

	        // Another example
	        int n2 = 4;
	        int[][] highways2 = {{0, 1, 30}, {0, 2, 50}, {1, 3, 5}, {2, 3, 20}};
	        int discounts2 = 1;
	        System.out.println("Result 2: " + solution.minimumCost(n2, highways2, discounts2)); // Expected: 45

	        // No discounts needed for the shortest path
	        int n3 = 3;
	        int[][] highways3 = {{0, 1, 100}, {1, 2, 100}, {0, 2, 1}};
	        int discounts3 = 2;
	        System.out.println("Result 3: " + solution.minimumCost(n3, highways3, discounts3)); // Expected: 1
	   

	}
	
	
	    class State {
	        int cost;
	        int city;
	        int discountsUsed;

	        public State(int cost, int city, int discountsUsed) {
	            this.cost = cost;
	            this.city = city;
	            this.discountsUsed = discountsUsed;
	        }
	    }

	    public int minimumCost(int n, int[][] highways, int discounts) {
	        // Build graph with adjacency list
	        Map<Integer, List<int[]>> graph = new HashMap<>();
	        for (int[] highway : highways) {
	            int u = highway[0];
	            int v = highway[1];
	            int toll = highway[2];
	            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, toll});
	            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, toll});
	        }

	        // dist[city][discounts_used]
	        int[][] dist = new int[n][discounts + 1];
	        for (int[] row : dist) {
	            Arrays.fill(row, Integer.MAX_VALUE);
	        }

	        // PriorityQueue: {cost, city, discountsUsed}
	        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));

	        dist[0][0] = 0;
	        pq.offer(new State(0, 0, 0));

	        while (!pq.isEmpty()) {
	            State current = pq.poll();
	            int cost = current.cost;
	            int city = current.city;
	            int k = current.discountsUsed;

	            if (city == n - 1) {
	                return cost;
	            }
	            if (cost > dist[city][k]) {
	                continue;
	            }

	            if (graph.containsKey(city)) {
	                for (int[] neighbor : graph.get(city)) {
	                    int nextCity = neighbor[0];
	                    int toll = neighbor[1];

	                    // Option 1: Don't use a discount
	                    int newCostWithoutDiscount = cost + toll;
	                    if (newCostWithoutDiscount < dist[nextCity][k]) {
	                        dist[nextCity][k] = newCostWithoutDiscount;
	                        pq.offer(new State(newCostWithoutDiscount, nextCity, k));
	                    }

	                    // Option 2: Use a discount
	                    if (k < discounts) {
	                        int newCostWithDiscount = cost + toll / 2;
	                        if (newCostWithDiscount < dist[nextCity][k + 1]) {
	                            dist[nextCity][k + 1] = newCostWithDiscount;
	                            pq.offer(new State(newCostWithDiscount, nextCity, k + 1));
	                        }
	                    }
	                }
	            }
	        }

	        return -1; // Should not be reached if a path exists
	    }
	}
