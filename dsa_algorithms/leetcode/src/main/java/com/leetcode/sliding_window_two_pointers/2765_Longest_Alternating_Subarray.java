package com.leetcode.sliding_window_two_pointers;

class Solution2765 {
    public int alternatingSubarray(int[] nums) {
        int ans = -1, n = nums.length;
        for (int i = 0; i < n; ++i) {
            int k = 1;
            int j = i;
            for (; j + 1 < n && nums[j + 1] - nums[j] == k; ++j) {
                k *= -1;
            }
            if (j - i + 1 > 1) {
                ans = Math.max(ans, j - i + 1);
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
        Solution2765 _tcSol = new Solution2765();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,4,3,4]");
        try {
            int[] nums = new int[]{2, 3, 4, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.alternatingSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,5,6]");
        try {
            int[] nums = new int[]{4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.alternatingSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}