package com.leetcode.dynamic_programming;

class Solution2786 {
    public long maxScore(int[] nums, int x) {
        long[] f = new long[2];
        Arrays.fill(f, -(1L << 60));
        f[nums[0] & 1] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int v = nums[i];
            f[v & 1] = Math.max(f[v & 1], f[v & 1 ^ 1] - x) + v;
        }
        return Math.max(f[0], f[1]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2786 _tcSol = new Solution2786();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,6,1,9,2], x = 5");
        try {
            int[] nums = new int[]{2, 3, 6, 1, 9, 2};
            int x = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(nums, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,4,6,8], x = 3");
        try {
            int[] nums = new int[]{2, 4, 6, 8};
            int x = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(nums, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();
    }
}