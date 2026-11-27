package com.leetcode.graphs_shortest_path;

class PersistentUnionFind1724 {
    private final int inf = 1 << 30;
    private int[] rank;
    private int[] parent;
    private int[] version;

    public PersistentUnionFind1724(int n) {
        rank = new int[n];
        parent = new int[n];
        version = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            version[i] = inf;
        }
    }

    public int find(int x, int t) {
        if (parent[x] == x || version[x] >= t) {
            return x;
        }
        return find(parent[x], t);
    }

    public boolean union(int a, int b, int t) {
        int pa = find(a, inf);
        int pb = find(b, inf);
        if (pa == pb) {
            return false;
        }
        if (rank[pa] > rank[pb]) {
            version[pb] = t;
            parent[pb] = pa;
        } else {
            version[pa] = t;
            parent[pa] = pb;
            if (rank[pa] == rank[pb]) {
                rank[pb]++;
            }
        }
        return true;
    }
}

class DistanceLimitedPathsExist1724 {
    private PersistentUnionFind1724 puf;

    public DistanceLimitedPathsExist1724(int n, int[][] edgeList) {
        puf = new PersistentUnionFind1724(n);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        for (var e : edgeList) {
            puf.union(e[0], e[1], e[2]);
        }
    }

    public boolean query(int p, int q, int limit) {
        return puf.find(p, limit) == puf.find(q, limit);
    }
}

/**
 * Your DistanceLimitedPathsExist1724 object will be instantiated and called as such:
 * DistanceLimitedPathsExist1724 obj = new DistanceLimitedPathsExist1724(n, edgeList);
 * boolean param_1 = obj.query(p,q,limit);
 */