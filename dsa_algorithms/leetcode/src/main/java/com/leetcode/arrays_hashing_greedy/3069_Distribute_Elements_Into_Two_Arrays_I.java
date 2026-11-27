package com.leetcode.arrays_hashing_greedy;

class Solution3069 {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int i = 0, j = 0;
        for (int k = 2; k < n; ++k) {
            if (arr1[i] > arr2[j]) {
                arr1[++i] = nums[k];
            } else {
                arr2[++j] = nums[k];
            }
        }
        for (int k = 0; k <= j; ++k) {
            arr1[++i] = arr2[k];
        }
        return arr1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3069 _tcSol = new Solution3069();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,3]");
        try {
            int[] nums = new int[]{2, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.resultArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,4,3,8]");
        try {
            int[] nums = new int[]{5, 4, 3, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.resultArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,3,4,8]");
        System.out.println();
    }
}