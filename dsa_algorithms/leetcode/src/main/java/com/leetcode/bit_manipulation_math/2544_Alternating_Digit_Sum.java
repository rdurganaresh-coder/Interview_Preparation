package com.leetcode.bit_manipulation_math;

class Solution2544 {
    public int alternateDigitSum(int n) {
        int ans = 0, sign = 1;
        for (char c : String.valueOf(n).toCharArray()) {
            int x = c - '0';
            ans += sign * x;
            sign *= -1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2544 _tcSol = new Solution2544();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 521");
        try {
            int n = 521;
            System.out.println("  Output  : " + _tcShow(_tcSol.alternateDigitSum(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 111");
        try {
            int n = 111;
            System.out.println("  Output  : " + _tcShow(_tcSol.alternateDigitSum(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 886996");
        try {
            int n = 886996;
            System.out.println("  Output  : " + _tcShow(_tcSol.alternateDigitSum(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}