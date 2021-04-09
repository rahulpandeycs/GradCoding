package src.AmzOA;

import java.util.Arrays;

public class CloudFrontCache {
    public int costEvaluation(int n, int[][] connections) {

        UnionFind uf = new UnionFind(n);

        for (int[] edge : connections) {
            int node1 = edge[0];
            int node2 = edge[1];
            uf.union(node1, node2);
        }
        int res = 0;
        System.out.println("Parent: " + Arrays.toString(uf.parent));
        System.out.println("rank: " + Arrays.toString(uf.rank));
        for (int i = 0; i < uf.parent.length; i++) {
            if (uf.parent[i] == i) {
//                System.out.println("Parent: " + Arrays.toString(uf.parent));
                res += Math.ceil(Math.sqrt(uf.rank[i]));
            } else {
                res += 1;
            }
        }
        return res;
    }

    class UnionFind {
        private int count = 0;
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return; // Already union skip

            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
            count--;
        }

        public int count() {
            return count;
        }
    }

    public static void main(String[] args) {
        CloudFrontCache cloudFrontCache = new CloudFrontCache();
        System.out.println("Maintenance cost: " + cloudFrontCache.costEvaluation(4, new int[][]{{0, 2}, {1, 2}}));
        System.out.println("Maintenance cost: " + cloudFrontCache.costEvaluation(10, new int[][]{{2, 6}, {3, 5}, {0, 1}, {2, 9}, {5, 6}}));
    }

}
