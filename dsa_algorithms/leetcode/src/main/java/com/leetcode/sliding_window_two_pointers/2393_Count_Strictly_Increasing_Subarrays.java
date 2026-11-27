package com.leetcode.sliding_window_two_pointers;

class Solution2393 {
    public long countSubarrays(int[] nums) {
        long ans = 1, cnt = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] < nums[i]) {
                ++cnt;
            } else {
                cnt = 1;
            }
            ans += cnt;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2393 _tcSol = new Solution2393();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,5,4,4,6]");
        try {
            int[] nums = new int[]{1, 3, 5, 4, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}
