package com.leetcode.bit_manipulation_math;

class Solution2180 {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; ++i) {
            int s = 0;
            for (int x = i; x > 0; x /= 10) {
                s += x % 10;
            }
            if (s % 2 == 0) {
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
        Solution2180 _tcSol = new Solution2180();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 4");
        try {
            int num = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.countEven(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 30");
        try {
            int num = 30;
            System.out.println("  Output  : " + _tcShow(_tcSol.countEven(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();
    }
}