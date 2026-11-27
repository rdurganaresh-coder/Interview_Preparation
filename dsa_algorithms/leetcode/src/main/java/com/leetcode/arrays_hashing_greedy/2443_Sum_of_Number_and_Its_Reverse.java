package com.leetcode.arrays_hashing_greedy;

class Solution2443 {
    public boolean sumOfNumberAndReverse(int num) {
        for (int x = 0; x <= num; ++x) {
            int k = x;
            int y = 0;
            while (k > 0) {
                y = y * 10 + k % 10;
                k /= 10;
            }
            if (x + y == num) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2443 _tcSol = new Solution2443();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 443");
        try {
            int num = 443;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfNumberAndReverse(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 63");
        try {
            int num = 63;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfNumberAndReverse(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = 181");
        try {
            int num = 181;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfNumberAndReverse(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}