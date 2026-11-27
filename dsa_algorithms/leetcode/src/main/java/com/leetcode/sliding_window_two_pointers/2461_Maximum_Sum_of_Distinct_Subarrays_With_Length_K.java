package com.leetcode.sliding_window_two_pointers;

class Solution2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>(k);
        long s = 0;
        for (int i = 0; i < k; ++i) {
            cnt.merge(nums[i], 1, Integer::sum);
            s += nums[i];
        }
        long ans = cnt.size() == k ? s : 0;
        for (int i = k; i < n; ++i) {
            cnt.merge(nums[i], 1, Integer::sum);
            if (cnt.merge(nums[i - k], -1, Integer::sum) == 0) {
                cnt.remove(nums[i - k]);
            }
            s += nums[i] - nums[i - k];
            if (cnt.size() == k) {
                ans = Math.max(ans, s);
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
        Solution2461 _tcSol = new Solution2461();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,5,4,2,9,9,9], k = 3");
        try {
            int[] nums = new int[]{1, 5, 4, 2, 9, 9, 9};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,4,4], k = 3");
        try {
            int[] nums = new int[]{4, 4, 4};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}