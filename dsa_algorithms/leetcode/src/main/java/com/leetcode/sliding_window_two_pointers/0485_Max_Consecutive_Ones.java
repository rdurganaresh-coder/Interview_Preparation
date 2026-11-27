package com.leetcode.sliding_window_two_pointers;

class Solution0485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, cnt = 0;
        for (int x : nums) {
            if (x == 1) {
                ans = Math.max(ans, ++cnt);
            } else {
                cnt = 0;
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
        Solution0485 _tcSol = new Solution0485();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,0,1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 0, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxConsecutiveOnes(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,0,1,1,0,1]");
        try {
            int[] nums = new int[]{1, 0, 1, 1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxConsecutiveOnes(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}