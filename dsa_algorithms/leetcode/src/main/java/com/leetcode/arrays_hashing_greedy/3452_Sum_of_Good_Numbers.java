package com.leetcode.arrays_hashing_greedy;

class Solution3452 {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (i >= k && nums[i] <= nums[i - k]) {
                continue;
            }
            if (i + k < n && nums[i] <= nums[i + k]) {
                continue;
            }
            ans += nums[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3452 _tcSol = new Solution3452();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,2,1,5,4], k = 2");
        try {
            int[] nums = new int[]{1, 3, 2, 1, 5, 4};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfGoodNumbers(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,1], k = 1");
        try {
            int[] nums = new int[]{2, 1};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfGoodNumbers(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
