package com.leetcode.arrays_hashing_greedy;

class Solution2770 {
    private Integer[] f;
    private int[] nums;
    private int n;
    private int target;

    public int maximumJumps(int[] nums, int target) {
        n = nums.length;
        this.target = target;
        this.nums = nums;
        f = new Integer[n];
        int ans = dfs(0);
        return ans < 0 ? -1 : ans;
    }

    private int dfs(int i) {
        if (i == n - 1) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        int ans = -(1 << 30);
        for (int j = i + 1; j < n; ++j) {
            if (Math.abs(nums[i] - nums[j]) <= target) {
                ans = Math.max(ans, 1 + dfs(j));
            }
        }
        return f[i] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2770 _tcSol = new Solution2770();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,6,4,1,2], target = 2");
        try {
            int[] nums = new int[]{1, 3, 6, 4, 1, 2};
            int target = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumJumps(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,6,4,1,2], target = 3");
        try {
            int[] nums = new int[]{1, 3, 6, 4, 1, 2};
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumJumps(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,3,6,4,1,2], target = 0");
        try {
            int[] nums = new int[]{1, 3, 6, 4, 1, 2};
            int target = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumJumps(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
