package com.leetcode.arrays_hashing_greedy;

class Solution0371 {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0371 _tcSol = new Solution0371();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = 1, b = 2");
        try {
            int a = 1;
            int b = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getSum(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = 2, b = 3");
        try {
            int a = 2;
            int b = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.getSum(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}