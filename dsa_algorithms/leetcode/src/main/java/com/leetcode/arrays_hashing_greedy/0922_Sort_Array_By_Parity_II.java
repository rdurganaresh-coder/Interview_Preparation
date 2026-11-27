package com.leetcode.arrays_hashing_greedy;

class Solution0922 {
    public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0, j = 1; i < nums.length; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) {
                    j += 2;
                }
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        return nums;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0922 _tcSol = new Solution0922();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,2,5,7]");
        try {
            int[] nums = new int[]{4, 2, 5, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortArrayByParityII(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,5,2,7]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3]");
        try {
            int[] nums = new int[]{2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortArrayByParityII(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3]");
        System.out.println();
    }
}