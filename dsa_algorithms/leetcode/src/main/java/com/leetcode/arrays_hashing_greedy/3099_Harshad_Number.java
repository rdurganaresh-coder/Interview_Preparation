package com.leetcode.arrays_hashing_greedy;

class Solution3099 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int s = 0;
        for (int y = x; y > 0; y /= 10) {
            s += y % 10;
        }
        return x % s == 0 ? s : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3099 _tcSol = new Solution3099();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = 18");
        try {
            int x = 18;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfTheDigitsOfHarshadNumber(x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = 23");
        try {
            int x = 23;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfTheDigitsOfHarshadNumber(x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}