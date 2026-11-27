package com.leetcode.dynamic_programming;

class Solution2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int k = 0;
        for (int x : nums) {
            if (x < pivot) {
                ans[k++] = x;
            }
        }
        for (int x : nums) {
            if (x == pivot) {
                ans[k++] = x;
            }
        }
        for (int x : nums) {
            if (x > pivot) {
                ans[k++] = x;
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
        Solution2161 _tcSol = new Solution2161();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [9,12,5,10,14,3,10], pivot = 10");
        try {
            int[] nums = new int[]{9, 12, 5, 10, 14, 3, 10};
            int pivot = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.pivotArray(nums, pivot)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,5,3,10,10,12,14]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-3,4,3,2], pivot = 2");
        try {
            int[] nums = new int[]{-3, 4, 3, 2};
            int pivot = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.pivotArray(nums, pivot)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-3,2,4,3]");
        System.out.println();
    }
}