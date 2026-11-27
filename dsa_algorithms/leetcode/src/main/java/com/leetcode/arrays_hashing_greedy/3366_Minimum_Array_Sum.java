package com.leetcode.arrays_hashing_greedy;

class Solution3366 {
    public int minArraySum(int[] nums, int d, int op1, int op2) {
        int n = nums.length;
        int[][][] f = new int[n + 1][op1 + 1][op2 + 1];
        final int inf = 1 << 29;
        for (var g : f) {
            for (var h : g) {
                Arrays.fill(h, inf);
            }
        }
        f[0][0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            int x = nums[i - 1];
            for (int j = 0; j <= op1; ++j) {
                for (int k = 0; k <= op2; ++k) {
                    f[i][j][k] = f[i - 1][j][k] + x;
                    if (j > 0) {
                        f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j - 1][k] + (x + 1) / 2);
                    }
                    if (k > 0 && x >= d) {
                        f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j][k - 1] + (x - d));
                    }
                    if (j > 0 && k > 0) {
                        int y = (x + 1) / 2;
                        if (y >= d) {
                            f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j - 1][k - 1] + (y - d));
                        }
                        if (x >= d) {
                            f[i][j][k]
                                = Math.min(f[i][j][k], f[i - 1][j - 1][k - 1] + (x - d + 1) / 2);
                        }
                    }
                }
            }
        }
        int ans = inf;
        for (int j = 0; j <= op1; ++j) {
            for (int k = 0; k <= op2; ++k) {
                ans = Math.min(ans, f[n][j][k]);
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
        Solution3366 _tcSol = new Solution3366();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,8,3,19,3], k = 3, op1 = 1, op2 = 1");
        try {
            int[] nums = new int[]{2, 8, 3, 19, 3};
            int d = 3;
            int op1 = 1;
            int op2 = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minArraySum(nums, d, op1, op2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "23");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,4,3], k = 3, op1 = 2, op2 = 1");
        try {
            int[] nums = new int[]{2, 4, 3};
            int d = 3;
            int op1 = 2;
            int op2 = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minArraySum(nums, d, op1, op2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
