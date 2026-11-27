package com.leetcode.sliding_window_two_pointers;

class Solution1312_2 {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i + 1][j], f[i][j - 1]) + 1;
                }
            }
        }
        return f[0][n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1312_2 _tcSol = new Solution1312_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"zzazz\"");
        try {
            String s = "zzazz";
            System.out.println("  Output  : " + _tcShow(_tcSol.minInsertions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"mbadm\"");
        try {
            String s = "mbadm";
            System.out.println("  Output  : " + _tcShow(_tcSol.minInsertions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"leetcode\"");
        try {
            String s = "leetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.minInsertions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}