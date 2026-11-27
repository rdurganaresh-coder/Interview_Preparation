package com.leetcode.arrays_hashing_greedy;

class Solution1959 {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        ++k;
        int n = nums.length;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            int s = 0, mx = 0;
            for (int j = i; j < n; ++j) {
                s += nums[j];
                mx = Math.max(mx, nums[j]);
                g[i][j] = mx * (j - i + 1) - s;
            }
        }
        int[][] f = new int[n + 1][k + 1];
        int inf = 0x3f3f3f3f;
        for (int i = 0; i < f.length; ++i) {
            Arrays.fill(f[i], inf);
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                for (int h = 0; h < i; ++h) {
                    f[i][j] = Math.min(f[i][j], f[h][j - 1] + g[h][i - 1]);
                }
            }
        }
        return f[n][k];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1959 _tcSol = new Solution1959();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [10,20], k = 0");
        try {
            int[] nums = new int[]{10, 20};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSpaceWastedKResizing(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,20,30], k = 1");
        try {
            int[] nums = new int[]{10, 20, 30};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSpaceWastedKResizing(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [10,20,15,30,20], k = 2");
        try {
            int[] nums = new int[]{10, 20, 15, 30, 20};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSpaceWastedKResizing(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}