package com.leetcode.bit_manipulation_math;

class Solution3336 {
    private int[] nums;
    private Integer[][][] f;
    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        int m = 0;
        for (int x : nums) {
            if (x > m) m = x;
        }
        this.f = new Integer[n + 1][m + 1][m + 1];
        return (dfs(n, 0, 0) - 1 + MOD) % MOD;
    }

    private int dfs(int i, int j, int k) {
        if (i == 0) {
            return j == k ? 1 : 0;
        }
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        int x = nums[i - 1];
        int res = ((dfs(i - 1, j, k) + dfs(i - 1, gcd(x, j), k)) % MOD + dfs(i - 1, j, gcd(x, k)))
            % MOD;
        f[i][j][k] = res;
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3336 _tcSol = new Solution3336();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsequencePairCount(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,20,30]");
        try {
            int[] nums = new int[]{10, 20, 30};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsequencePairCount(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.subsequencePairCount(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "50");
        System.out.println();
    }
}