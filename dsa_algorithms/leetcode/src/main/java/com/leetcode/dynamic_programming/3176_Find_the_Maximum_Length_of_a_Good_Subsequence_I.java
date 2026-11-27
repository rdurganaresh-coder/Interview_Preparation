package com.leetcode.dynamic_programming;

class Solution3176 {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] f = new int[n][k + 1];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int h = 0; h <= k; ++h) {
                for (int j = 0; j < i; ++j) {
                    if (nums[i] == nums[j]) {
                        f[i][h] = Math.max(f[i][h], f[j][h]);
                    } else if (h > 0) {
                        f[i][h] = Math.max(f[i][h], f[j][h - 1]);
                    }
                }
                ++f[i][h];
            }
            ans = Math.max(ans, f[i][k]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3176 _tcSol = new Solution3176();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1,1,3], k = 2");
        try {
            int[] nums = new int[]{1, 2, 1, 1, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumLength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,1], k = 0");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 1};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumLength(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}