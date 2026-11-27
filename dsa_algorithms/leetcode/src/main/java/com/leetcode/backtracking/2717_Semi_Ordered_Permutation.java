package com.leetcode.backtracking;

class Solution2717 {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        for (int k = 0; k < n; ++k) {
            if (nums[k] == 1) {
                i = k;
            }
            if (nums[k] == n) {
                j = k;
            }
        }
        int k = i < j ? 1 : 2;
        return i + n - j - k;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2717 _tcSol = new Solution2717();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,4,3]");
        try {
            int[] nums = new int[]{2, 1, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.semiOrderedPermutation(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,4,1,3]");
        try {
            int[] nums = new int[]{2, 4, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.semiOrderedPermutation(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,3,4,2,5]");
        try {
            int[] nums = new int[]{1, 3, 4, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.semiOrderedPermutation(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}