package com.leetcode.arrays_hashing_greedy;

class Solution1414 {
    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1;
        while (b <= k) {
            int c = a + b;
            a = b;
            b = c;
        }
        int ans = 0;
        while (k > 0) {
            if (k >= b) {
                k -= b;
                ++ans;
            }
            int c = b - a;
            b = a;
            a = c;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1414 _tcSol = new Solution1414();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 7");
        try {
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinFibonacciNumbers(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 10");
        try {
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinFibonacciNumbers(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "k = 19");
        try {
            int k = 19;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinFibonacciNumbers(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}