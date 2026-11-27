package com.leetcode.backtracking;

class Solution2044 {
    private int mx;
    private int ans;
    private int[] nums;

    public int countMaxOrSubsets(int[] nums) {
        mx = 0;
        for (int x : nums) {
            mx |= x;
        }
        this.nums = nums;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int t) {
        if (i == nums.length) {
            if (t == mx) {
                ++ans;
            }
            return;
        }
        dfs(i + 1, t);
        dfs(i + 1, t | nums[i]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2044 _tcSol = new Solution2044();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,1]");
        try {
            int[] nums = new int[]{3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countMaxOrSubsets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,2]");
        try {
            int[] nums = new int[]{2, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.countMaxOrSubsets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,2,1,5]");
        try {
            int[] nums = new int[]{3, 2, 1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.countMaxOrSubsets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}