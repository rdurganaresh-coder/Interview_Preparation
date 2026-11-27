package com.leetcode.sliding_window_two_pointers;

class Solution2930_3 {
    public int stringCount(int n) {
        final int mod = (int) 1e9 + 7;
        long[][][] f = new long[2][3][2];
        f[1][2][1] = 1;
        for (int i = 0; i < n; ++i) {
            long[][][] g = new long[2][3][2];
            for (int l = 0; l < 2; ++l) {
                for (int e = 0; e < 3; ++e) {
                    for (int t = 0; t < 2; ++t) {
                        long a = f[l][e][t] * 23;
                        long b = f[Math.min(1, l + 1)][e][t];
                        long c = f[l][Math.min(2, e + 1)][t];
                        long d = f[l][e][Math.min(1, t + 1)];
                        g[l][e][t] = (a + b + c + d) % mod;
                    }
                }
            }
            f = g;
        }
        return (int) f[0][0][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2930_3 _tcSol = new Solution2930_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4");
        try {
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.stringCount(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 10");
        try {
            int n = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.stringCount(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "83943898");
        System.out.println();
    }
}
