package com.leetcode.arrays_hashing_greedy;

class Solution1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n << 1];
        for (int i = 0, j = 0; i < n; ++i) {
            ans[j++] = nums[i];
            ans[j++] = nums[i + n];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1470 _tcSol = new Solution1470();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,5,1,3,4,7], n = 3");
        try {
            int[] nums = new int[]{2, 5, 1, 3, 4, 7};
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.shuffle(nums, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,5,4,1,7]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,4,3,2,1], n = 4");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.shuffle(nums, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,4,2,3,3,2,4,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,2,2], n = 2");
        try {
            int[] nums = new int[]{1, 1, 2, 2};
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.shuffle(nums, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,1,2]");
        System.out.println();
    }
}