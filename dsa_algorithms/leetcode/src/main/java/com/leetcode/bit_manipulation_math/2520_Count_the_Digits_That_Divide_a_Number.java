package com.leetcode.bit_manipulation_math;

class Solution2520 {
    public int countDigits(int num) {
        int ans = 0;
        for (int x = num; x > 0; x /= 10) {
            if (num % (x % 10) == 0) {
                ++ans;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2520 _tcSol = new Solution2520();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 7");
        try {
            int num = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.countDigits(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 121");
        try {
            int num = 121;
            System.out.println("  Output  : " + _tcShow(_tcSol.countDigits(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = 1248");
        try {
            int num = 1248;
            System.out.println("  Output  : " + _tcShow(_tcSol.countDigits(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}