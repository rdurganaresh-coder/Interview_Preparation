package com.leetcode.sliding_window_two_pointers;

class Solution2348 {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int cnt = 0;
        for (int x : nums) {
            if (x == 0) {
                ans += ++cnt;
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
        Solution2348 _tcSol = new Solution2348();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,0,0,2,0,0,4]");
        try {
            int[] nums = new int[]{1, 3, 0, 0, 2, 0, 0, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.zeroFilledSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,0,0,2,0,0]");
        try {
            int[] nums = new int[]{0, 0, 0, 2, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.zeroFilledSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,10,2019]");
        try {
            int[] nums = new int[]{2, 10, 2019};
            System.out.println("  Output  : " + _tcShow(_tcSol.zeroFilledSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
