package com.leetcode.arrays_hashing_greedy;

class Solution2836 {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int n = receiver.size(), m = 64 - Long.numberOfLeadingZeros(k);
        int[][] f = new int[n][m];
        long[][] g = new long[n][m];
        for (int i = 0; i < n; ++i) {
            f[i][0] = receiver.get(i);
            g[i][0] = i;
        }
        for (int j = 1; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                f[i][j] = f[f[i][j - 1]][j - 1];
                g[i][j] = g[i][j - 1] + g[f[i][j - 1]][j - 1];
            }
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            int p = i;
            long t = 0;
            for (int j = 0; j < m; ++j) {
                if ((k >> j & 1) == 1) {
                    t += g[p][j];
                    p = f[p][j];
                }
            }
            ans = Math.max(ans, p + t);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution2836 _tcSol = new Solution2836();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "receiver = [2,0,1], k = 4");
        try {
            List<Integer> receiver = _tcL(2, 0, 1);
            long k = 4L;
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaxFunctionValue(receiver, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "receiver = [1,1,1,2,3], k = 3");
        try {
            List<Integer> receiver = _tcL(1, 1, 1, 2, 3);
            long k = 3L;
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaxFunctionValue(receiver, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}