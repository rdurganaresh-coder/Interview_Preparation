package com.leetcode.strings;

class Hashing3327 {
    private final long[] p;
    private final long[] h;
    private final long mod;

    public Hashing3327(String word, long base, int mod) {
        int n = word.length();
        p = new long[n + 1];
        h = new long[n + 1];
        p[0] = 1;
        this.mod = mod;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * base % mod;
            h[i] = (h[i - 1] * base + word.charAt(i - 1)) % mod;
        }
    }

    public long query(int l, int r) {
        return (h[r] - h[l - 1] * p[r - l + 1] % mod + mod) % mod;
    }
}

class Solution3327 {
    private char[] s;
    private int[][] pos;
    private List<Integer>[] g;
    private StringBuilder dfsStr = new StringBuilder();

    public boolean[] findAnswer(int[] parent, String s) {
        this.s = s.toCharArray();
        int n = s.length();
        g = new List[n];
        pos = new int[n][0];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parent[i]].add(i);
        }
        dfs(0);
        final int base = 13331;
        final int mod = 998244353;
        Hashing3327 h1 = new Hashing3327(dfsStr.toString(), base, mod);
        Hashing3327 h2 = new Hashing3327(new StringBuilder(dfsStr).reverse().toString(), base, mod);
        boolean[] ans = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int l = pos[i][0], r = pos[i][1];
            int k = r - l + 1;
            long v1 = h1.query(l, l + k / 2 - 1);
            long v2 = h2.query(n + 1 - r, n + 1 - r + k / 2 - 1);
            ans[i] = v1 == v2;
        }
        return ans;
    }

    private void dfs(int i) {
        int l = dfsStr.length() + 1;
        for (int j : g[i]) {
            dfs(j);
        }
        dfsStr.append(s[i]);
        int r = dfsStr.length();
        pos[i] = new int[] {l, r};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3327 _tcSol = new Solution3327();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "parent = [-1,0,0,1,1,2], s = \"aababa\"");
        try {
            int[] parent = new int[]{-1, 0, 0, 1, 1, 2};
            String s = "aababa";
            System.out.println("  Output  : " + _tcShow(_tcSol.findAnswer(parent, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,true,false,true,true,true]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "parent = [-1,0,0,0,0], s = \"aabcb\"");
        try {
            int[] parent = new int[]{-1, 0, 0, 0, 0};
            String s = "aabcb";
            System.out.println("  Output  : " + _tcShow(_tcSol.findAnswer(parent, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,true,true,true,true]");
        System.out.println();
    }
}
