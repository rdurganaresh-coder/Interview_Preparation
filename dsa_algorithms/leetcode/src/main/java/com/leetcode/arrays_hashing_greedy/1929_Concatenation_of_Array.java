package com.leetcode.arrays_hashing_greedy;

class Solution1929 {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n << 1];
        for (int i = 0; i < n << 1; ++i) {
            ans[i] = nums[i % n];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1929 _tcSol = new Solution1929();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1]");
        try {
            int[] nums = new int[]{1, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.getConcatenation(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,1,1,2,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,2,1]");
        try {
            int[] nums = new int[]{1, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.getConcatenation(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3,2,1,1,3,2,1]");
        System.out.println();
    }
}