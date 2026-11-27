package com.leetcode.sliding_window_two_pointers;

class Solution1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            s[i] = s[i - 1] ^ arr[i - 1];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = s[r + 1] ^ s[l];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1310 _tcSol = new Solution1310();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]");
        try {
            int[] arr = new int[]{1, 3, 4, 8};
            int[][] queries = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{0, 3}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.xorQueries(arr, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,7,14,8]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]");
        try {
            int[] arr = new int[]{4, 8, 2, 10};
            int[][] queries = new int[][]{new int[]{2, 3}, new int[]{1, 3}, new int[]{0, 0}, new int[]{0, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.xorQueries(arr, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[8,0,4,4]");
        System.out.println();
    }
}