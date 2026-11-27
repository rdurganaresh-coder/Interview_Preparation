package com.leetcode.arrays_hashing_greedy;

class Solution2643 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];
        for (int i = 0; i < mat.length; ++i) {
            int cnt = 0;
            for (int x : mat[i]) {
                cnt += x;
            }
            if (ans[1] < cnt) {
                ans[0] = i;
                ans[1] = cnt;
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
        Solution2643 _tcSol = new Solution2643();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[0,1],[1,0]]");
        try {
            int[][] mat = new int[][]{new int[]{0, 1}, new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.rowAndMaximumOnes(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[0,0,0],[0,1,1]]");
        try {
            int[][] mat = new int[][]{new int[]{0, 0, 0}, new int[]{0, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.rowAndMaximumOnes(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "mat = [[0,0],[1,1],[0,0]]");
        try {
            int[][] mat = new int[][]{new int[]{0, 0}, new int[]{1, 1}, new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.rowAndMaximumOnes(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();
    }
}
