package com.leetcode.arrays_hashing_greedy;

class Solution1981 {
    public int minimizeTheDifference(int[][] mat, int target) {
        boolean[] f = {true};
        for (var row : mat) {
            int mx = 0;
            for (int x : row) {
                mx = Math.max(mx, x);
            }
            boolean[] g = new boolean[f.length + mx];
            for (int x : row) {
                for (int j = x; j < f.length + x; ++j) {
                    g[j] |= f[j - x];
                }
            }
            f = g;
        }
        int ans = 1 << 30;
        for (int j = 0; j < f.length; ++j) {
            if (f[j]) {
                ans = Math.min(ans, Math.abs(j - target));
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
        Solution1981 _tcSol = new Solution1981();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13");
        try {
            int[][] mat = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            int target = 13;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeTheDifference(mat, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[1],[2],[3]], target = 100");
        try {
            int[][] mat = new int[][]{new int[]{1}, new int[]{2}, new int[]{3}};
            int target = 100;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeTheDifference(mat, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "94");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "mat = [[1,2,9,8,7]], target = 6");
        try {
            int[][] mat = new int[][]{new int[]{1, 2, 9, 8, 7}};
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeTheDifference(mat, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
