package com.leetcode.arrays_hashing_greedy;

class Solution0977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, k = n - 1; i <= j; --k) {
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];
            if (a > b) {
                ans[k] = a;
                ++i;
            } else {
                ans[k] = b;
                --j;
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
        Solution0977 _tcSol = new Solution0977();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-4,-1,0,3,10]");
        try {
            int[] nums = new int[]{-4, -1, 0, 3, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortedSquares(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,9,16,100]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-7,-3,2,3,11]");
        try {
            int[] nums = new int[]{-7, -3, 2, 3, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortedSquares(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,9,9,49,121]");
        System.out.println();
    }
}