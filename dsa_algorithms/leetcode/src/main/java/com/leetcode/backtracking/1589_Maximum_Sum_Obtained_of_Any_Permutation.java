package com.leetcode.backtracking;

class Solution1589 {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] d = new int[n];
        for (var req : requests) {
            int l = req[0], r = req[1];
            d[l]++;
            if (r + 1 < n) {
                d[r + 1]--;
            }
        }
        for (int i = 1; i < n; ++i) {
            d[i] += d[i - 1];
        }
        Arrays.sort(nums);
        Arrays.sort(d);
        final int mod = (int) 1e9 + 7;
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = (ans + 1L * nums[i] * d[i]) % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1589 _tcSol = new Solution1589();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5], requests = [[1,3],[0,1]]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            int[][] requests = new int[][]{new int[]{1, 3}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumRangeQuery(nums, requests)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,6], requests = [[0,1]]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 6};
            int[][] requests = new int[][]{new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumRangeQuery(nums, requests)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 10};
            int[][] requests = new int[][]{new int[]{0, 2}, new int[]{1, 3}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumRangeQuery(nums, requests)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "47");
        System.out.println();
    }
}