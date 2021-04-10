package src.AmzOA;

import java.util.*;
import java.util.stream.Collectors;

public class minCostToConnectNodes {

    class UF {
        private int[] parent;  // parent[i] = parent of i
        private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
        public int count;      // number of connected components

        public UF(int n) {
            if (n < 0) throw new IllegalArgumentException();
            parent = new int[n];
            rank = new byte[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            count = n;
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pr = find(p);
            int qr = find(q);
            if (pr == qr) return;
            if (rank[pr] < rank[qr]) {
                parent[pr] = qr;
            } else {
                parent[qr] = pr;
                if (rank[pr] == rank[qr]) rank[pr]++;
            }
            count--;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
    }

    public int minCostToConnectNodes(int n, List<List<Integer>> edges, List<List<Integer>> newEdges) {
        UF uf = new UF(n + 1); // + 1 because nodes are 1-based
        for (List<Integer> edge : edges) {
            uf.union(edge.get(0), edge.get(1));
        }

        Queue<List<Integer>> pq = new PriorityQueue<>(newEdges.size(), (e1, e2) -> Integer.compare(e1.get(2), e2.get(2)));
        pq.addAll(newEdges);

        int totalCost = 0;
        // 2 because nodes are 1-based and we have 1 unused component at index 0
        while (!pq.isEmpty() && uf.count != 2) {
            List<Integer> edge = pq.poll();
            if (!uf.connected(edge.get(0), edge.get(1))) {
                uf.union(edge.get(0), edge.get(1));
                totalCost += edge.get(2);
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int edgesLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < edgesLength; i++) {
            edges.add(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        int costsLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> costs = new ArrayList<>();
        for (int i = 0; i < costsLength; i++) {
            costs.add(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();

        minCostToConnectNodes s = new minCostToConnectNodes();
        int res = s.minCostToConnectNodes(n, edges, costs);
        System.out.println(res);
    }
}
