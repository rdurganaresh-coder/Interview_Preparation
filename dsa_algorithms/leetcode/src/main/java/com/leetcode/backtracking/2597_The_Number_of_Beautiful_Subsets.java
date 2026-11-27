package com.leetcode.backtracking;

class Solution2597 {
    private int[] nums;
    private int[] cnt = new int[1010];
    private int ans = -1;
    private int k;

    public int beautifulSubsets(int[] nums, int k) {
        this.k = k;
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i >= nums.length) {
            ++ans;
            return;
        }
        dfs(i + 1);
        boolean ok1 = nums[i] + k >= cnt.length || cnt[nums[i] + k] == 0;
        boolean ok2 = nums[i] - k < 0 || cnt[nums[i] - k] == 0;
        if (ok1 && ok2) {
            ++cnt[nums[i]];
            dfs(i + 1);
            --cnt[nums[i]];
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2597 _tcSol = new Solution2597();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,4,6], k = 2");
        try {
            int[] nums = new int[]{2, 4, 6};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.beautifulSubsets(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1], k = 1");
        try {
            int[] nums = new int[]{1};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.beautifulSubsets(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}