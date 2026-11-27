package com.leetcode.arrays_hashing_greedy;

class Solution0565 {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }
            int cur = nums[i], m = 1;
            vis[cur] = true;
            while (nums[cur] != nums[i]) {
                cur = nums[cur];
                m++;
                vis[cur] = true;
            }
            res = Math.max(res, m);
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0565 _tcSol = new Solution0565();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,4,0,3,1,6,2]");
        try {
            int[] nums = new int[]{5, 4, 0, 3, 1, 6, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayNesting(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,2]");
        try {
            int[] nums = new int[]{0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayNesting(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}