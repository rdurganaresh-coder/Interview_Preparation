package com.leetcode.arrays_hashing_greedy;

class Solution3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] d = new int[n + 1];
        for (var q : queries) {
            int l = q[0], r = q[1];
            ++d[l];
            --d[r + 1];
        }
        for (int i = 0, s = 0; i < n; ++i) {
            s += d[i];
            if (nums[i] > s) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3355 _tcSol = new Solution3355();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,0,1], queries = [[0,2]]");
        try {
            int[] nums = new int[]{1, 0, 1};
            int[][] queries = new int[][]{new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isZeroArray(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,3,2,1], queries = [[1,3],[0,2]]");
        try {
            int[] nums = new int[]{4, 3, 2, 1};
            int[][] queries = new int[][]{new int[]{1, 3}, new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isZeroArray(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
