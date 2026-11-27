package com.leetcode.arrays_hashing_greedy;

class Solution2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int j = search(nums, lower - nums[i], i + 1);
            int k = search(nums, upper - nums[i] + 1, i + 1);
            ans += k - j;
        }
        return ans;
    }

    private int search(int[] nums, int x, int left) {
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2563 _tcSol = new Solution2563();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,7,4,4,5], lower = 3, upper = 6");
        try {
            int[] nums = new int[]{0, 1, 7, 4, 4, 5};
            int lower = 3;
            int upper = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.countFairPairs(nums, lower, upper)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,7,9,2,5], lower = 11, upper = 11");
        try {
            int[] nums = new int[]{1, 7, 9, 2, 5};
            int lower = 11;
            int upper = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.countFairPairs(nums, lower, upper)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}