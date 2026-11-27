package com.leetcode.sliding_window_two_pointers;

class Solution3392 {
    public int countSubarrays(int[] nums) {
        int ans = 0;
        for (int i = 1; i + 1 < nums.length; ++i) {
            if ((nums[i - 1] + nums[i + 1]) * 2 == nums[i]) {
                ++ans;
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
        Solution3392 _tcSol = new Solution3392();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1,4,1]");
        try {
            int[] nums = new int[]{1, 2, 1, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
