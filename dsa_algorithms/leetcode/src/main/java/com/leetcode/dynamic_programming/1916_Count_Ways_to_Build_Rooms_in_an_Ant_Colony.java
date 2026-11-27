package com.leetcode.dynamic_programming;

class Solution1916 {
    private static final int MOD = 1_000_000_007;
    private List<Integer>[] g;
    private long[] fact;
    private long[] invFact;
    private long ans = 1;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[prevRoom[i]].add(i);
        }
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; ++i) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[n] = qpow(fact[n], MOD - 2);
        for (int i = n; i > 0; --i) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }
        dfs(0);
        return (int) ans;
    }

    private int dfs(int u) {
        int merged = 0;
        for (int v : g[u]) {
            int cn = dfs(v);
            if (merged != 0) {
                ans = ans * comb(merged + cn, cn) % MOD;
            }
            merged += cn;
        }
        return merged + 1;
    }

    private long comb(int n, int k) {
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    private long qpow(long a, long n) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1916 _tcSol = new Solution1916();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prevRoom = [-1,0,1]");
        try {
            int[] prevRoom = new int[]{-1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToBuildRooms(prevRoom)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prevRoom = [-1,0,0,1,2]");
        try {
            int[] prevRoom = new int[]{-1, 0, 0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToBuildRooms(prevRoom)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
