package com.leetcode.arrays_hashing_greedy;

class Solution3397 {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0, pre = Integer.MIN_VALUE;
        for (int x : nums) {
            int cur = Math.min(x + k, Math.max(x - k, pre + 1));
            if (cur > pre) {
                ++ans;
                pre = cur;
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
        Solution3397 _tcSol = new Solution3397();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2,3,3,4], k = 2");
        try {
            int[] nums = new int[]{1, 2, 2, 3, 3, 4};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistinctElements(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,4,4,4], k = 1");
        try {
            int[] nums = new int[]{4, 4, 4, 4};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistinctElements(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
