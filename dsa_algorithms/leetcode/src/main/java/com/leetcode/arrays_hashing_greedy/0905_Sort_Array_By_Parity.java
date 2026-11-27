package com.leetcode.arrays_hashing_greedy;

class Solution0905 {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 == 0) {
                ++i;
            } else if (nums[j] % 2 == 1) {
                --j;
            } else {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                ++i;
                --j;
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
        Solution0905 _tcSol = new Solution0905();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,1,2,4]");
        try {
            int[] nums = new int[]{3, 1, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortArrayByParity(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,4,3,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0]");
        try {
            int[] nums = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortArrayByParity(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();
    }
}