package com.leetcode.arrays_hashing_greedy;

class Solution2149 {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0, j = 1;
        for (int x : nums) {
            if (x > 0) {
                ans[i] = x;
                i += 2;
            } else {
                ans[j] = x;
                j += 2;
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
        Solution2149 _tcSol = new Solution2149();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,1,-2,-5,2,-4]");
        try {
            int[] nums = new int[]{3, 1, -2, -5, 2, -4};
            System.out.println("  Output  : " + _tcShow(_tcSol.rearrangeArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,-2,1,-5,2,-4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,1]");
        try {
            int[] nums = new int[]{-1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.rearrangeArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,-1]");
        System.out.println();
    }
}