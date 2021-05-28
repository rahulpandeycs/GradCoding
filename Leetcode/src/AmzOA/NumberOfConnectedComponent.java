package src.AmzOA;

import java.util.*;

public class NumberOfConnectedComponent {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][]{{0,1}, {1,2}, {3,4}};
        System.out.println(getNumberOfConnectedComponent(n,edges));

        n = 5;
        edges = new int[][]{{0,1}, {1,2}, {2,3},{3,4}};
        System.out.println(getNumberOfConnectedComponent(n,edges));
    }

    private static int getNumberOfConnectedComponent(int n, int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int count =0;
        Set<Integer> visited = new HashSet<>();
        for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet()){
            if(!visited.contains(entry.getKey())) {
                visited.add(entry.getKey());
                dfs(graph, visited, entry.getKey());
                count++;
            }
        }
        return count;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int entry) {

        if(!graph.containsKey(entry) || graph.get(entry).size() == 0) return;

        for(int neighbor : graph.get(entry)){
            if(!visited.contains(neighbor)){
                visited.add(neighbor);
                dfs(graph, visited,neighbor);
            }
        }
    }
}
