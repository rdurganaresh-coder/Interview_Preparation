package com.leetcode.trees_tries;

class TreeAncestor1483 {
    private int[][] p;

    public TreeAncestor1483(int n, int[] parent) {
        p = new int[n][18];
        for (var e : p) {
            Arrays.fill(e, -1);
        }
        for (int i = 0; i < n; ++i) {
            p[i][0] = parent[i];
        }
        for (int j = 1; j < 18; ++j) {
            for (int i = 0; i < n; ++i) {
                if (p[i][j - 1] == -1) {
                    continue;
                }
                p[i][j] = p[p[i][j - 1]][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 17; i >= 0; --i) {
            if (((k >> i) & 1) == 1) {
                node = p[node][i];
                if (node == -1) {
                    break;
                }
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor1483 object will be instantiated and called as such:
 * TreeAncestor1483 obj = new TreeAncestor1483(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */