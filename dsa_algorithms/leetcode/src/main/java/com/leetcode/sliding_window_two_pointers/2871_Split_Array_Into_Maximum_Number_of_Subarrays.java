package com.leetcode.sliding_window_two_pointers;

class Solution2871 {
    public int maxSubarrays(int[] nums) {
        int score = -1;
        int ans = 1;
        for (int num : nums) {
            score &= num;
            if (score == 0) {
                ans++;
                score = -1;
            }
        }
        return ans == 1 ? 1 : ans - 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2871 _tcSol = new Solution2871();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,0,2,0,1,2]");
        try {
            int[] nums = new int[]{1, 0, 2, 0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,7,1,3]");
        try {
            int[] nums = new int[]{5, 7, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}