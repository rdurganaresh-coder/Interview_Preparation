package com.leetcode.dynamic_programming;

class Solution2522_2 {
    public int minimumPartition(String s, int k) {
        int n = s.length();
        int inf = 1 << 30;
        int[] f = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            f[i] = inf;
        }
        for (int i = n - 1; i >= 0; --i) {
            long v = 0;
            for (int j = i; j < n; ++j) {
                v = v * 10 + (s.charAt(j) - '0');
                if (v > k) {
                    break;
                }
                f[i] = Math.min(f[i], f[j + 1]);
            }
            ++f[i];
        }
        return f[0] < inf ? f[0] : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2522_2 _tcSol = new Solution2522_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"165462\", k = 60");
        try {
            String s = "165462";
            int k = 60;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPartition(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"238182\", k = 5");
        try {
            String s = "238182";
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPartition(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
