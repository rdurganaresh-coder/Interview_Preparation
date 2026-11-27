package com.leetcode.bit_manipulation_math;

class Solution0400 {
    public int findNthDigit(int n) {
        int k = 1, cnt = 9;
        while ((long) k * cnt < n) {
            n -= k * cnt;
            ++k;
            cnt *= 10;
        }
        int num = (int) Math.pow(10, k - 1) + (n - 1) / k;
        int idx = (n - 1) % k;
        return String.valueOf(num).charAt(idx) - '0';
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0400 _tcSol = new Solution0400();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3");
        try {
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findNthDigit(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 11");
        try {
            int n = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.findNthDigit(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}