package com.leetcode.arrays_hashing_greedy;

class Solution1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int j = -(k + 1);
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                if (i - j - 1 < k) {
                    return false;
                }
                j = i;
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
        Solution1437 _tcSol = new Solution1437();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,0,0,0,1,0,0,1], k = 2");
        try {
            int[] nums = new int[]{1, 0, 0, 0, 1, 0, 0, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kLengthApart(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,0,0,1,0,1], k = 2");
        try {
            int[] nums = new int[]{1, 0, 0, 1, 0, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kLengthApart(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}