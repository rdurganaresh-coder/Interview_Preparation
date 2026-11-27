package com.leetcode.arrays_hashing_greedy;

class Solution2784 {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int[] cnt = new int[201];
        for (int x : nums) {
            ++cnt[x];
        }
        if (cnt[n] != 2) {
            return false;
        }
        for (int i = 1; i < n; ++i) {
            if (cnt[i] != 1) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2784 _tcSol = new Solution2784();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2, 1, 3]");
        try {
            int[] nums = new int[]{2, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.isGood(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1, 3, 3, 2]");
        try {
            int[] nums = new int[]{1, 3, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.isGood(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1, 1]");
        try {
            int[] nums = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.isGood(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "nums = [3, 4, 4, 1, 2, 1]");
        try {
            int[] nums = new int[]{3, 4, 4, 1, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.isGood(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}