package com.leetcode.dynamic_programming;

class Solution3202 {
    public int maximumLength(int[] nums, int k) {
        int[][] f = new int[k][k];
        int ans = 0;
        for (int x : nums) {
            x %= k;
            for (int j = 0; j < k; ++j) {
                int y = (j - x + k) % k;
                f[x][y] = f[y][x] + 1;
                ans = Math.max(ans, f[x][y]);
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
        Solution3202 _tcSol = new Solution3202();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5], k = 2");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumLength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,4,2,3,1,4], k = 3");
        try {
            int[] nums = new int[]{1, 4, 2, 3, 1, 4};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumLength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}