package src.AmzOA;

import java.util.*;

//https://leetcode.com/problems/connecting-cities-with-minimum-cost/
/*
* There are N cities numbered from 1 to N.
    You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)

    Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.

    Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
    Output: 6
    Explanation:
    Choosing any 2 edges will connect all cities so we choose the minimum 2.
* */

public class ConnectingCitiesWithMinimumCost {

    public static int minimumCost(int N, int[][] connections) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] connection : connections){
            graph.putIfAbsent(connection[0], new ArrayList<>());
            graph.putIfAbsent(connection[1], new ArrayList<>());

            graph.get(connection[0]).add(new int[]{connection[1], connection[2]});
            graph.get(connection[1]).add(new int[]{connection[0], connection[2]});
        }

        int cost = 0, numberOfEdges = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        minHeap.add(new int[]{1,0});
        Set<Integer> visited = new HashSet<>();

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            if(visited.contains(curr[0])) continue;

            visited.add(curr[0]);
            numberOfEdges++;
            cost += curr[1];
            for(int[] neighbor : graph.get(curr[0])){
                if(visited.contains(neighbor[0])) continue;
                minHeap.add(neighbor);
            }
        }
        return numberOfEdges == N ? cost :-1;
    }

    public static void main(String[] args) {

        int[][] edges = new int[][]{{1,2,5}, {1,3,6}, {2,3,1}};
        System.out.println(minimumCost(3, edges));

        edges = new int[][]{{1,2,3}, {3,4,4}};
        System.out.println(minimumCost(4, edges));
    }
}
