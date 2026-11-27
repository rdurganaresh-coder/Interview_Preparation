package com.leetcode.dynamic_programming;

class Solution3040 {
    private Integer[][] f;
    private int[] nums;
    private int s;
    private int n;

    public int maxOperations(int[] nums) {
        this.nums = nums;
        n = nums.length;
        int a = g(2, n - 1, nums[0] + nums[1]);
        int b = g(0, n - 3, nums[n - 2] + nums[n - 1]);
        int c = g(1, n - 2, nums[0] + nums[n - 1]);
        return 1 + Math.max(a, Math.max(b, c));
    }

    private int g(int i, int j, int s) {
        f = new Integer[n][n];
        this.s = s;
        return dfs(i, j);
    }

    private int dfs(int i, int j) {
        if (j - i < 1) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = 0;
        if (nums[i] + nums[i + 1] == s) {
            ans = Math.max(ans, 1 + dfs(i + 2, j));
        }
        if (nums[i] + nums[j] == s) {
            ans = Math.max(ans, 1 + dfs(i + 1, j - 1));
        }
        if (nums[j - 1] + nums[j] == s) {
            ans = Math.max(ans, 1 + dfs(i, j - 2));
        }
        return f[i][j] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3040 _tcSol = new Solution3040();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,2,1,2,3,4]");
        try {
            int[] nums = new int[]{3, 2, 1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,2,6,1,4]");
        try {
            int[] nums = new int[]{3, 2, 6, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}