package com.leetcode.arrays_hashing_greedy;

class Solution3289_2 {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;
        int xx = nums[n] ^ nums[n + 1];
        for (int i = 0; i < n; ++i) {
            xx ^= i ^ nums[i];
        }
        int k = Integer.numberOfTrailingZeros(xx);
        int[] ans = new int[2];
        for (int x : nums) {
            ans[x >> k & 1] ^= x;
        }
        for (int i = 0; i < n; ++i) {
            ans[i >> k & 1] ^= i;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3289_2 _tcSol = new Solution3289_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,1,0]");
        try {
            int[] nums = new int[]{0, 1, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.getSneakyNumbers(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,3,2,1,3,2]");
        try {
            int[] nums = new int[]{0, 3, 2, 1, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.getSneakyNumbers(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [7,1,5,4,3,4,6,0,9,5,8,2]");
        try {
            int[] nums = new int[]{7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.getSneakyNumbers(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,5]");
        System.out.println();
    }
}
