package com.leetcode.trees_tries;

class PrimeTable2867 {
    private final boolean[] prime;

    public PrimeTable2867(int n) {
        prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= n; ++i) {
            if (prime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    public boolean isPrime(int x) {
        return prime[x];
    }
}

class UnionFind2867 {
    private final int[] p;
    private final int[] size;

    public UnionFind2867(int n) {
        p = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) {
            return false;
        }
        if (size[pa] > size[pb]) {
            p[pb] = pa;
            size[pa] += size[pb];
        } else {
            p[pa] = pb;
            size[pb] += size[pa];
        }
        return true;
    }

    public int size(int x) {
        return size[find(x)];
    }
}

class Solution2867 {
    private static final PrimeTable2867 PT = new PrimeTable2867(100010);

    public long countPaths(int n, int[][] edges) {
        List<Integer>[] g = new List[n + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        UnionFind2867 uf = new UnionFind2867(n + 1);
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
            if (!PT.isPrime(u) && !PT.isPrime(v)) {
                uf.union(u, v);
            }
        }
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (PT.isPrime(i)) {
                long t = 0;
                for (int j : g[i]) {
                    if (!PT.isPrime(j)) {
                        long cnt = uf.size(j);
                        ans += cnt;
                        ans += cnt * t;
                        t += cnt;
                    }
                }
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
        Solution2867 _tcSol = new Solution2867();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, edges = [[1,2],[1,3],[2,4],[2,5]]");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 4}, new int[]{2, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPaths(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, edges = [[1,2],[1,3],[2,4],[3,5],[3,6]]");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 4}, new int[]{3, 5}, new int[]{3, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPaths(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}