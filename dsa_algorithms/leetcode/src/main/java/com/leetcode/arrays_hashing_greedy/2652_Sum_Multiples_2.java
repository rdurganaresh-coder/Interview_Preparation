package com.leetcode.arrays_hashing_greedy;

class Solution2652_2 {
    private int n;

    public int sumOfMultiples(int n) {
        this.n = n;
        return f(3) + f(5) + f(7) - f(3 * 5) - f(3 * 7) - f(5 * 7) + f(3 * 5 * 7);
    }

    private int f(int x) {
        int m = n / x;
        return (x + m * x) * m / 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2652_2 _tcSol = new Solution2652_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 7");
        try {
            int n = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfMultiples(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 10");
        try {
            int n = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfMultiples(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "40");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 9");
        try {
            int n = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfMultiples(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "30");
        System.out.println();
    }
}