package com.leetcode.dynamic_programming;

class Solution1563 {
    private int n;
    private int[] s;
    private int[] nums;
    private Integer[][] f;

    public int stoneGameV(int[] stoneValue) {
        n = stoneValue.length;
        s = new int[n + 1];
        nums = stoneValue;
        f = new Integer[n][n];
        for (int i = 1; i <= n; ++i) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = 0, l = 0, r = s[j + 1] - s[i];
        for (int k = i; k < j; ++k) {
            l += nums[k];
            r -= nums[k];
            if (l < r) {
                if (ans > l * 2) {
                    continue;
                }
                ans = Math.max(ans, l + dfs(i, k));
            } else if (l > r) {
                if (ans > r * 2) {
                    break;
                }
                ans = Math.max(ans, r + dfs(k + 1, j));
            } else {
                ans = Math.max(ans, Math.max(l + dfs(i, k), r + dfs(k + 1, j)));
            }
        }
        return f[i][j] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1563 _tcSol = new Solution1563();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stoneValue = [6,2,3,4,5,5]");
        try {
            int[] stoneValue = new int[]{6, 2, 3, 4, 5, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameV(stoneValue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stoneValue = [7,7,7,7,7,7,7]");
        try {
            int[] stoneValue = new int[]{7, 7, 7, 7, 7, 7, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameV(stoneValue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "stoneValue = [4]");
        try {
            int[] stoneValue = new int[]{4};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameV(stoneValue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
