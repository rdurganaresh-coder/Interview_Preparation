package com.leetcode.dynamic_programming;

class Solution1735 {
    private static final int N = 10020;
    private static final int MOD = (int) 1e9 + 7;
    private static final long[] F = new long[N];
    private static final long[] G = new long[N];
    private static final List<Integer>[] P = new List[N];

    static {
        F[0] = 1;
        G[0] = 1;
        Arrays.setAll(P, k -> new ArrayList<>());
        for (int i = 1; i < N; ++i) {
            F[i] = F[i - 1] * i % MOD;
            G[i] = qmi(F[i], MOD - 2, MOD);
            int x = i;
            for (int j = 2; j <= x / j; ++j) {
                if (x % j == 0) {
                    int cnt = 0;
                    while (x % j == 0) {
                        ++cnt;
                        x /= j;
                    }
                    P[i].add(cnt);
                }
            }
            if (x > 1) {
                P[i].add(1);
            }
        }
    }

    public static long qmi(long a, long k, long p) {
        long res = 1;
        while (k != 0) {
            if ((k & 1) == 1) {
                res = res * a % p;
            }
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }

    public static long comb(int n, int k) {
        return (F[n] * G[k] % MOD) * G[n - k] % MOD;
    }

    public int[] waysToFillArray(int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int n = queries[i][0], k = queries[i][1];
            long t = 1;
            for (int x : P[k]) {
                t = t * comb(x + n - 1, n - 1) % MOD;
            }
            ans[i] = (int) t;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1735 _tcSol = new Solution1735();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "queries = [[2,6],[5,1],[73,660]]");
        try {
            int[][] queries = new int[][]{new int[]{2, 6}, new int[]{5, 1}, new int[]{73, 660}};
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToFillArray(queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,1,50734910]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "queries = [[1,1],[2,2],[3,3],[4,4],[5,5]]");
        try {
            int[][] queries = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}, new int[]{4, 4}, new int[]{5, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToFillArray(queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,10,5]");
        System.out.println();
    }
}