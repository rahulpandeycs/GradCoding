package src.premium;

import java.util.*;

public class ConnectingCitiesWithMinCost {

    public int minimumCost(int N, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());  // start from 0
        for (int[] c : connections) {
            graph.get(c[0]).add(new int[]{c[1], c[2]});
            graph.get(c[1]).add(new int[]{c[0], c[2]});
        }

        Queue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);  // minHeap compare with cost
        boolean[] visited = new boolean[N+1];
        pq.offer(new int[]{1,0}); // suppose there is a start 0 node with 0-1 cost is 0.
        int numberOfCitiesVisited = 0, cost = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;

            cost += cur[1];
            visited[cur[0]] = true;
            numberOfCitiesVisited++;  // not all node may be visited.

            List<int[]> neis = graph.get(cur[0]);
            for (int[] nei : neis) {
                if (visited[nei[0]]) continue; // if already visted, it means there is a path with smaller cost that can get to it, so we do not need to access it again.
                pq.offer(nei);
            }
        }
        return numberOfCitiesVisited == N ? cost : -1;
    }
}
