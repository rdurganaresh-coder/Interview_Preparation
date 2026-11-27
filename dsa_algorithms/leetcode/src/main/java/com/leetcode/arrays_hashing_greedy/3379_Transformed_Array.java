package com.leetcode.arrays_hashing_greedy;

class Solution3379 {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = nums[(i + nums[i] % n + n) % n];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3379 _tcSol = new Solution3379();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,-2,1,1]");
        try {
            int[] nums = new int[]{3, -2, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.constructTransformedArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,1,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,4,-1]");
        try {
            int[] nums = new int[]{-1, 4, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.constructTransformedArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1,4]");
        System.out.println();
    }
}
