package com.leetcode.sliding_window_two_pointers;

class Solution2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int l = 0, r = 0; r < nums.length; ++r) {
            cnt.merge(nums[r], 1, Integer::sum);
            while (cnt.get(nums[r]) > k) {
                cnt.merge(nums[l++], -1, Integer::sum);
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2958 _tcSol = new Solution2958();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,1,2,3,1,2], k = 2");
        try {
            int[] nums = new int[]{1, 2, 3, 1, 2, 3, 1, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarrayLength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,1,2,1,2,1,2], k = 1");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 1, 2, 1, 2};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarrayLength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [5,5,5,5,5,5,5], k = 4");
        try {
            int[] nums = new int[]{5, 5, 5, 5, 5, 5, 5};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarrayLength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}