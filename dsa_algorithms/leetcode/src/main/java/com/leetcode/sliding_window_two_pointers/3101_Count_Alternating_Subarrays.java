package com.leetcode.sliding_window_two_pointers;

class Solution3101 {
    public long countAlternatingSubarrays(int[] nums) {
        long ans = 1, s = 1;
        for (int i = 1; i < nums.length; ++i) {
            s = nums[i] != nums[i - 1] ? s + 1 : 1;
            ans += s;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3101 _tcSol = new Solution3101();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,1,1]");
        try {
            int[] nums = new int[]{0, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countAlternatingSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,0,1,0]");
        try {
            int[] nums = new int[]{1, 0, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.countAlternatingSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}