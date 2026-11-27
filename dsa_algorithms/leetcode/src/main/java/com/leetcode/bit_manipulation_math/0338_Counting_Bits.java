package com.leetcode.bit_manipulation_math;

class Solution0338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0338 _tcSol = new Solution0338();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countBits(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5");
        try {
            int n = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countBits(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,1,2,1,2]");
        System.out.println();
    }
}