package com.leetcode.sliding_window_two_pointers;

class Solution1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
        int ans = 0;
        for (int i = firstLen, t = 0; i + secondLen - 1 < n; ++i) {
            t = Math.max(t, s[i] - s[i - firstLen]);
            ans = Math.max(ans, t + s[i + secondLen] - s[i]);
        }
        for (int i = secondLen, t = 0; i + firstLen - 1 < n; ++i) {
            t = Math.max(t, s[i] - s[i - secondLen]);
            ans = Math.max(ans, t + s[i + firstLen] - s[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1031 _tcSol = new Solution1031();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2");
        try {
            int[] nums = new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4};
            int firstLen = 1;
            int secondLen = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumTwoNoOverlap(nums, firstLen, secondLen)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2");
        try {
            int[] nums = new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0};
            int firstLen = 3;
            int secondLen = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumTwoNoOverlap(nums, firstLen, secondLen)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "29");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3");
        try {
            int[] nums = new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
            int firstLen = 4;
            int secondLen = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumTwoNoOverlap(nums, firstLen, secondLen)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "31");
        System.out.println();
    }
}