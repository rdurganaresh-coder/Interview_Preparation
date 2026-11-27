package com.leetcode.arrays_hashing_greedy;

class Solution2576 {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int i = 0, n = nums.length;
        for (int j = (n + 1) / 2; j < n; ++j) {
            if (nums[i] * 2 <= nums[j]) {
                ++i;
            }
        }
        return i * 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2576 _tcSol = new Solution2576();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,5,2,4]");
        try {
            int[] nums = new int[]{3, 5, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumOfMarkedIndices(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [9,2,5,4]");
        try {
            int[] nums = new int[]{9, 2, 5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumOfMarkedIndices(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [7,6,8]");
        try {
            int[] nums = new int[]{7, 6, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumOfMarkedIndices(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
