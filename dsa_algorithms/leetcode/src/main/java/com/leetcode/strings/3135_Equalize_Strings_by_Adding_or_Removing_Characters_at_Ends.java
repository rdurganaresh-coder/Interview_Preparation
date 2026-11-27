package com.leetcode.strings;

class Solution3135 {
    public int minOperations(String initial, String target) {
        int m = initial.length(), n = target.length();
        int[][] f = new int[m + 1][n + 1];
        int mx = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (initial.charAt(i - 1) == target.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    mx = Math.max(mx, f[i][j]);
                }
            }
        }
        return m + n - 2 * mx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3135 _tcSol = new Solution3135();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "initial = \"abcde\", target = \"cdef\"");
        try {
            String initial = "abcde";
            String target = "cdef";
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(initial, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "initial = \"axxy\", target = \"yabx\"");
        try {
            String initial = "axxy";
            String target = "yabx";
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(initial, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "initial = \"xyz\", target = \"xyz\"");
        try {
            String initial = "xyz";
            String target = "xyz";
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(initial, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}