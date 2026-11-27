package com.leetcode.backtracking;

class Solution1863_2 {
    private int ans;
    private int[] nums;

    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int s) {
        if (i >= nums.length) {
            ans += s;
            return;
        }
        dfs(i + 1, s);
        dfs(i + 1, s ^ nums[i]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1863_2 _tcSol = new Solution1863_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3]");
        try {
            int[] nums = new int[]{1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsetXORSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,1,6]");
        try {
            int[] nums = new int[]{5, 1, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsetXORSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,4,5,6,7,8]");
        try {
            int[] nums = new int[]{3, 4, 5, 6, 7, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsetXORSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "480");
        System.out.println();
    }
}