package com.leetcode.arrays_hashing_greedy;

class Solution1716 {
    public int totalMoney(int n) {
        int k = n / 7, b = n % 7;
        int s1 = (28 + 28 + 7 * (k - 1)) * k / 2;
        int s2 = (k + 1 + k + 1 + b - 1) * b / 2;
        return s1 + s2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1716 _tcSol = new Solution1716();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4");
        try {
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.totalMoney(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 10");
        try {
            int n = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.totalMoney(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "37");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 20");
        try {
            int n = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.totalMoney(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "96");
        System.out.println();
    }
}
