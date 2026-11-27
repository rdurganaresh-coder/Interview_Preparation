package com.leetcode.dynamic_programming;

class Solution2547 {
    private Integer[] f;
    private int[] nums;
    private int n, k;

    public int minCost(int[] nums, int k) {
        n = nums.length;
        this.k = k;
        this.nums = nums;
        f = new Integer[n];
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        int[] cnt = new int[n];
        int one = 0;
        int ans = 1 << 30;
        for (int j = i; j < n; ++j) {
            int x = ++cnt[nums[j]];
            if (x == 1) {
                ++one;
            } else if (x == 2) {
                --one;
            }
            ans = Math.min(ans, k + j - i + 1 - one + dfs(j + 1));
        }
        return f[i] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2547 _tcSol = new Solution2547();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1,2,1,3,3], k = 2");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 1, 3, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,1,2,1], k = 2");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,1,2,1], k = 5");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 1};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}
