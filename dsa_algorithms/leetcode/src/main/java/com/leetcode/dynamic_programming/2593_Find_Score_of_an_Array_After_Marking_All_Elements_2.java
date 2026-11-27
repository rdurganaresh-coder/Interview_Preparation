package com.leetcode.dynamic_programming;

class Solution2593_2 {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n + 2];
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> nums[i] - nums[j]);
        long ans = 0;
        for (int i : idx) {
            if (!vis[i + 1]) {
                ans += nums[i];
                vis[i] = true;
                vis[i + 2] = true;
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
        Solution2593_2 _tcSol = new Solution2593_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,3,4,5,2]");
        try {
            int[] nums = new int[]{2, 1, 3, 4, 5, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,5,1,3,2]");
        try {
            int[] nums = new int[]{2, 3, 5, 1, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}