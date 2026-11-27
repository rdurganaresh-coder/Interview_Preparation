package com.leetcode.sliding_window_two_pointers;

class Solution1016 {
    public boolean queryString(String s, int n) {
        if (n > 1000) {
            return false;
        }
        for (int i = n; i > n / 2; i--) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1016 _tcSol = new Solution1016();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"0110\", n = 3");
        try {
            String s = "0110";
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.queryString(s, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"0110\", n = 4");
        try {
            String s = "0110";
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.queryString(s, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}