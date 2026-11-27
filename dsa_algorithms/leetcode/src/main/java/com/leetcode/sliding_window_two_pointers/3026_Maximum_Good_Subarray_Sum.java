package com.leetcode.sliding_window_two_pointers;

class Solution3026 {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> p = new HashMap<>();
        p.put(nums[0], 0L);
        long s = 0;
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            s += nums[i];
            if (p.containsKey(nums[i] - k)) {
                ans = Math.max(ans, s - p.get(nums[i] - k));
            }
            if (p.containsKey(nums[i] + k)) {
                ans = Math.max(ans, s - p.get(nums[i] + k));
            }
            if (i + 1 < n && (!p.containsKey(nums[i + 1]) || p.get(nums[i + 1]) > s)) {
                p.put(nums[i + 1], s);
            }
        }
        return ans == Long.MIN_VALUE ? 0 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3026 _tcSol = new Solution3026();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,6], k = 1");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 6};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,3,2,4,5], k = 3");
        try {
            int[] nums = new int[]{-1, 3, 2, 4, 5};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-1,-2,-3,-4], k = 2");
        try {
            int[] nums = new int[]{-1, -2, -3, -4};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-6");
        System.out.println();
    }
}