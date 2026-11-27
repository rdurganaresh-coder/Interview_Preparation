package com.leetcode.trees_tries;

class Solution1489 {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        for (int i = 0; i < edges.length; ++i) {
            int[] e = edges[i];
            int[] t = new int[4];
            System.arraycopy(e, 0, t, 0, 3);
            t[3] = i;
            edges[i] = t;
        }
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        int v = 0;
        UnionFind1489 uf = new UnionFind1489(n);
        for (int[] e : edges) {
            int f = e[0], t = e[1], w = e[2];
            if (uf.union(f, t)) {
                v += w;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; ++i) {
            ans.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int f = e[0], t = e[1], w = e[2], i = e[3];
            uf = new UnionFind1489(n);
            int k = 0;
            for (int[] ne : edges) {
                int x = ne[0], y = ne[1], z = ne[2], j = ne[3];
                if (j != i && uf.union(x, y)) {
                    k += z;
                }
            }
            if (uf.getN() > 1 || (uf.getN() == 1 && k > v)) {
                ans.get(0).add(i);
                continue;
            }
            uf = new UnionFind1489(n);
            uf.union(f, t);
            k = w;
            for (int[] ne : edges) {
                int x = ne[0], y = ne[1], z = ne[2], j = ne[3];
                if (j != i && uf.union(x, y)) {
                    k += z;
                }
            }
            if (k == v) {
                ans.get(1).add(i);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1489 _tcSol = new Solution1489();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{0, 1, 1}, new int[]{1, 2, 1}, new int[]{2, 3, 2}, new int[]{0, 3, 2}, new int[]{0, 4, 3}, new int[]{3, 4, 3}, new int[]{1, 4, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findCriticalAndPseudoCriticalEdges(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1],[2,3,4,5]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{0, 1, 1}, new int[]{1, 2, 1}, new int[]{2, 3, 1}, new int[]{0, 3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findCriticalAndPseudoCriticalEdges(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[],[0,1,2,3]]");
        System.out.println();
    }
}

class UnionFind1489 {
    private int[] p;
    private int n;

    public UnionFind1489(int n) {
        p = new int[n];
        this.n = n;
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
    }

    public int getN() {
        return n;
    }

    public boolean union(int a, int b) {
        if (find(a) == find(b)) {
            return false;
        }
        p[find(a)] = find(b);
        --n;
        return true;
    }

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}