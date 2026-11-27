package com.leetcode.sliding_window_two_pointers;

class Solution0487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, cnt = 0;
        for (int x : nums) {
            cnt += x ^ 1;
            if (cnt > 1) {
                cnt -= nums[l++] ^ 1;
            }
        }
        return nums.length - l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0487 _tcSol = new Solution0487();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,0,1,1,0]");
        try {
            int[] nums = new int[]{1, 0, 1, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxConsecutiveOnes(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,0,1,1,0,1]");
        try {
            int[] nums = new int[]{1, 0, 1, 1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxConsecutiveOnes(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}