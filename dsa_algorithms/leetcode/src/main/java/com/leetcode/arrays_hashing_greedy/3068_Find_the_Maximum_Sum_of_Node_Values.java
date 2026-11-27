package com.leetcode.arrays_hashing_greedy;

class Solution3068 {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long f0 = 0, f1 = -0x3f3f3f3f;
        for (int x : nums) {
            long tmp = f0;
            f0 = Math.max(f0 + x, f1 + (x ^ k));
            f1 = Math.max(f1 + x, tmp + (x ^ k));
        }
        return f0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3068 _tcSol = new Solution3068();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1], k = 3, edges = [[0,1],[0,2]]");
        try {
            int[] nums = new int[]{1, 2, 1};
            int k = 3;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumValueSum(nums, k, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3], k = 7, edges = [[0,1]]");
        try {
            int[] nums = new int[]{2, 3};
            int k = 7;
            int[][] edges = new int[][]{new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumValueSum(nums, k, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [7,7,7,7,7,7], k = 3, edges = [[0,1],[0,2],[0,3],[0,4],[0,5]]");
        try {
            int[] nums = new int[]{7, 7, 7, 7, 7, 7};
            int k = 3;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4}, new int[]{0, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumValueSum(nums, k, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "42");
        System.out.println();
    }
}
