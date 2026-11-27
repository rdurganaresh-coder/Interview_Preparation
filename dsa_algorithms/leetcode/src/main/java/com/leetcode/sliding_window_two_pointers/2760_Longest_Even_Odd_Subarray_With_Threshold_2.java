package com.leetcode.sliding_window_two_pointers;

class Solution2760_2 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        for (int l = 0, n = nums.length; l < n;) {
            if (nums[l] % 2 == 0 && nums[l] <= threshold) {
                int r = l + 1;
                while (r < n && nums[r] % 2 != nums[r - 1] % 2 && nums[r] <= threshold) {
                    ++r;
                }
                ans = Math.max(ans, r - l);
                l = r;
            } else {
                ++l;
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
        Solution2760_2 _tcSol = new Solution2760_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,2,5,4], threshold = 5");
        try {
            int[] nums = new int[]{3, 2, 5, 4};
            int threshold = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestAlternatingSubarray(nums, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2], threshold = 2");
        try {
            int[] nums = new int[]{1, 2};
            int threshold = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestAlternatingSubarray(nums, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,3,4,5], threshold = 4");
        try {
            int[] nums = new int[]{2, 3, 4, 5};
            int threshold = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestAlternatingSubarray(nums, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}