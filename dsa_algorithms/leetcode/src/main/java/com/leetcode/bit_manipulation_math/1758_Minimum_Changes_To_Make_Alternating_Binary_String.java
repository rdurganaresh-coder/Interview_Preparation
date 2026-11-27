package com.leetcode.bit_manipulation_math;

class Solution1758 {
    public int minOperations(String s) {
        int cnt = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            cnt += (s.charAt(i) != "01".charAt(i & 1) ? 1 : 0);
        }
        return Math.min(cnt, n - cnt);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1758 _tcSol = new Solution1758();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"0100\"");
        try {
            String s = "0100";
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"10\"");
        try {
            String s = "10";
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"1111\"");
        try {
            String s = "1111";
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}