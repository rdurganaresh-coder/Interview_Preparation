package com.leetcode.bit_manipulation_math;

class Solution2342 {
    public int maximumSum(int[] nums) {
        int[] d = new int[100];
        int ans = -1;
        for (int v : nums) {
            int x = 0;
            for (int y = v; y > 0; y /= 10) {
                x += y % 10;
            }
            if (d[x] > 0) {
                ans = Math.max(ans, d[x] + v);
            }
            d[x] = Math.max(d[x], v);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2342 _tcSol = new Solution2342();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [18,43,36,13,7]");
        try {
            int[] nums = new int[]{18, 43, 36, 13, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "54");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,12,19,14]");
        try {
            int[] nums = new int[]{10, 12, 19, 14};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}