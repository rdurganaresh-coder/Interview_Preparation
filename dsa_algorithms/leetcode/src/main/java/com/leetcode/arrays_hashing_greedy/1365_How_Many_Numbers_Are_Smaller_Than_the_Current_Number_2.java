package com.leetcode.arrays_hashing_greedy;

class Solution1365_2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[102];
        for (int x : nums) {
            ++cnt[x + 1];
        }
        for (int i = 1; i < cnt.length; ++i) {
            cnt[i] += cnt[i - 1];
        }
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = cnt[nums[i]];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1365_2 _tcSol = new Solution1365_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [8,1,2,2,3]");
        try {
            int[] nums = new int[]{8, 1, 2, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallerNumbersThanCurrent(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,0,1,1,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [6,5,4,8]");
        try {
            int[] nums = new int[]{6, 5, 4, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallerNumbersThanCurrent(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1,0,3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [7,7,7,7]");
        try {
            int[] nums = new int[]{7, 7, 7, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallerNumbersThanCurrent(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,0,0]");
        System.out.println();
    }
}