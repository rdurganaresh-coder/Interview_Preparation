package com.leetcode.strings;

class Solution1653 {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        int b = 0;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) == 'b') {
                f[i] = f[i - 1];
                ++b;
            } else {
                f[i] = Math.min(f[i - 1] + 1, b);
            }
        }
        return f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1653 _tcSol = new Solution1653();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aababbab\"");
        try {
            String s = "aababbab";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDeletions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"bbaaaaabb\"");
        try {
            String s = "bbaaaaabb";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDeletions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}