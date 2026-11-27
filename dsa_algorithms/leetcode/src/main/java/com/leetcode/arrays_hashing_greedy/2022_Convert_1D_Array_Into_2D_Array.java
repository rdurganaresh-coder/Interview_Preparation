package com.leetcode.arrays_hashing_greedy;

class Solution2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][0];
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans[i][j] = original[i * n + j];
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
        Solution2022 _tcSol = new Solution2022();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "original = [1,2,3,4], m = 2, n = 2");
        try {
            int[] original = new int[]{1, 2, 3, 4};
            int m = 2;
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.construct2DArray(original, m, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2],[3,4]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "original = [1,2,3], m = 1, n = 3");
        try {
            int[] original = new int[]{1, 2, 3};
            int m = 1;
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.construct2DArray(original, m, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2,3]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "original = [1,2], m = 1, n = 1");
        try {
            int[] original = new int[]{1, 2};
            int m = 1;
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.construct2DArray(original, m, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}