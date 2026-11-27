package com.leetcode.dynamic_programming;

class Solution3110 {
    public int scoreOfString(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); ++i) {
            ans += Math.abs(s.charAt(i - 1) - s.charAt(i));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3110 _tcSol = new Solution3110();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"hello\"");
        try {
            String s = "hello";
            System.out.println("  Output  : " + _tcShow(_tcSol.scoreOfString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"zaz\"");
        try {
            String s = "zaz";
            System.out.println("  Output  : " + _tcShow(_tcSol.scoreOfString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "50");
        System.out.println();
    }
}