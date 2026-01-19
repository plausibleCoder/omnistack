package com.learn.dsa.basic.graphs;
/**
 * 
 * @author karthik
 *There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 

Example 1:


Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
Example 3:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 

Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
 */
import java.util.*;
public class CheapestFlightsWithinKStopsLeetCode787 {
	
	class State {
        int cost;
        int city;
        int stops;

        public State(int cost, int city, int stops) {
            this.cost = cost;
            this.city = city;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build the graph using an adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        // Priority queue to explore flights with minimum cost
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new State(0, src, 0));

        // Keep track of the minimum cost to reach each city with a certain number of stops
        // `minCosts[city][stops]`
        int[][] minCosts = new int[n][k + 2];
        for (int[] row : minCosts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minCosts[src][0] = 0;

        while (!pq.isEmpty()) {
            State current = pq.poll();

            if (current.city == dst) {
                return current.cost;
            }

            if (current.stops > k) {
                continue;
            }

            if (graph.containsKey(current.city)) {
                for (int[] neighbor : graph.get(current.city)) {
                    int nextCity = neighbor[0];
                    int flightPrice = neighbor[1];
                    int newCost = current.cost + flightPrice;
                    int newStops = current.stops + 1;

                    if (newStops <= k + 1 && newCost < minCosts[nextCity][newStops]) {
                         minCosts[nextCity][newStops] = newCost;
                         pq.offer(new State(newCost, nextCity, newStops));
                    }
                }
            }
        }

        // If the destination was never reached, it means there is no path within k stops.
        int result = Integer.MAX_VALUE;
        for(int i = 0; i <= k + 1; i++) {
            result = Math.min(result, minCosts[dst][i]);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
