package com.leetcode.arrays_hashing_greedy;

class Solution2235 {
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2235 _tcSol = new Solution2235();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num1 = 12, num2 = 5");
        try {
            int num1 = 12;
            int num2 = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.sum(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num1 = -10, num2 = 4");
        try {
            int num1 = -10;
            int num2 = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.sum(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-6");
        System.out.println();
    }
}