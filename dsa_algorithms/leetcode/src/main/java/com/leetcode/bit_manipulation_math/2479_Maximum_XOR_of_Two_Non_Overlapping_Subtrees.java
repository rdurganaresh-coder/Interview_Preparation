package com.leetcode.bit_manipulation_math;

class Trie2479 {
    Trie2479[] children = new Trie2479[2];

    void insert(long x) {
        Trie2479 node = this;
        for (int i = 47; i >= 0; --i) {
            int v = (int) (x >> i) & 1;
            if (node.children[v] == null) {
                node.children[v] = new Trie2479();
            }
            node = node.children[v];
        }
    }

    long search(long x) {
        Trie2479 node = this;
        long res = 0;
        for (int i = 47; i >= 0; --i) {
            int v = (int) (x >> i) & 1;
            if (node == null) {
                return res;
            }
            if (node.children[v ^ 1] != null) {
                res = res << 1 | 1;
                node = node.children[v ^ 1];
            } else {
                res <<= 1;
                node = node.children[v];
            }
        }
        return res;
    }
}

class Solution2479 {
    private List<Integer>[] g;
    private int[] vals;
    private long[] s;
    private Trie2479 tree;
    private long ans;

    public long maxXor(int n, int[][] edges, int[] values) {
        g = new List[n];
        s = new long[n];
        vals = values;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        dfs1(0, -1);
        tree = new Trie2479();
        dfs2(0, -1);
        return ans;
    }

    private void dfs2(int i, int fa) {
        ans = Math.max(ans, tree.search(s[i]));
        for (int j : g[i]) {
            if (j != fa) {
                dfs2(j, i);
            }
        }
        tree.insert(s[i]);
    }

    private long dfs1(int i, int fa) {
        long t = vals[i];
        for (int j : g[i]) {
            if (j != fa) {
                t += dfs1(j, i);
            }
        }
        s[i] = t;
        return t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2479 _tcSol = new Solution2479();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, edges = [[0,1],[0,2],[1,3],[1,4],[2,5]], values = [2,8,3,6,2,5]");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 5}};
            int[] values = new int[]{2, 8, 3, 6, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxXor(n, edges, values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, edges = [[0,1],[1,2]], values = [4,6,1]");
        try {
            int n = 3;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}};
            int[] values = new int[]{4, 6, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxXor(n, edges, values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
