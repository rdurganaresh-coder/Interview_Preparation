package com.leetcode.arrays_hashing_greedy;

class Solution2769 {
    public int theMaximumAchievableX(int num, int t) {
        return num + t * 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2769 _tcSol = new Solution2769();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 4, t = 1");
        try {
            int num = 4;
            int t = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.theMaximumAchievableX(num, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 3, t = 2");
        try {
            int num = 3;
            int t = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.theMaximumAchievableX(num, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}