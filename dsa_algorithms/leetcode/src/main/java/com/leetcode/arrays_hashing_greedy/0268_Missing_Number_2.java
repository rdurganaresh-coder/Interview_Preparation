package com.leetcode.arrays_hashing_greedy;

class Solution0268_2 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = n;
        for (int i = 0; i < n; ++i) {
            ans += i - nums[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0268_2 _tcSol = new Solution0268_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,0,1]");
        try {
            int[] nums = new int[]{3, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.missingNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1]");
        try {
            int[] nums = new int[]{0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.missingNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [9,6,4,2,3,5,7,0,1]");
        try {
            int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.missingNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}