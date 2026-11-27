package com.leetcode.dynamic_programming;

class Solution1977 {
    public int numberOfCombinations(String num) {
        final int mod = (int) 1e9 + 7;
        int n = num.length();
        int[][] lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (num.charAt(i) == num.charAt(j)) {
                    lcp[i][j] = 1 + lcp[i + 1][j + 1];
                }
            }
        }
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                int v = 0;
                if (num.charAt(i - j) != '0') {
                    if (i - j - j >= 0) {
                        int x = lcp[i - j][i - j - j];
                        if (x >= j || num.charAt(i - j + x) >= num.charAt(i - j - j + x)) {
                            v = dp[i - j][j];
                        }
                    }
                    if (v == 0) {
                        v = dp[i - j][Math.min(j - 1, i - j)];
                    }
                }
                dp[i][j] = (dp[i][j - 1] + v) % mod;
            }
        }
        return dp[n][n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1977 _tcSol = new Solution1977();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"327\"");
        try {
            String num = "327";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfCombinations(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"094\"");
        try {
            String num = "094";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfCombinations(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = \"0\"");
        try {
            String num = "0";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfCombinations(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
