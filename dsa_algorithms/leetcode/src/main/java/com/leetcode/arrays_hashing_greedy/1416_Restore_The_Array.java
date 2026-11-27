package com.leetcode.arrays_hashing_greedy;

class Solution1416 {
    public int numberOfArrays(String s, int k) {
        final int mod = 1_000_000_007;
        int n = s.length();
        int[] f = new int[n + 1];
        f[n] = 1;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '0') {
                continue;
            }
            long x = 0;
            for (int j = i; j < n; ++j) {
                x = x * 10 + s.charAt(j) - '0';
                if (x > k) {
                    break;
                }
                f[i] = (int) ((f[i] + f[j + 1]) % mod);
            }
        }
        return f[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1416 _tcSol = new Solution1416();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"1000\", k = 10000");
        try {
            String s = "1000";
            int k = 10000;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfArrays(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"1000\", k = 10");
        try {
            String s = "1000";
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfArrays(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"1317\", k = 2000");
        try {
            String s = "1317";
            int k = 2000;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfArrays(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}
