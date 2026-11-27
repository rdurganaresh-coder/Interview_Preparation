package com.leetcode.dynamic_programming;

class Solution1940 {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int[] cnt = new int[101];
        for (var row : arrays) {
            for (int x : row) {
                ++cnt[x];
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 101; ++i) {
            if (cnt[i] == arrays.length) {
                ans.add(i);
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
        Solution1940 _tcSol = new Solution1940();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arrays = [[1,3,4], [1,4,7,9]]");
        try {
            int[][] arrays = new int[][]{new int[]{1, 3, 4}, new int[]{1, 4, 7, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonSubsequence(arrays)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arrays = [[2,3,6,8], [1,2,3,5,6,7,10], [2,3,4,6,9]]");
        try {
            int[][] arrays = new int[][]{new int[]{2, 3, 6, 8}, new int[]{1, 2, 3, 5, 6, 7, 10}, new int[]{2, 3, 4, 6, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonSubsequence(arrays)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,6]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arrays = [[1,2,3,4,5], [6,7,8]]");
        try {
            int[][] arrays = new int[][]{new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonSubsequence(arrays)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}
