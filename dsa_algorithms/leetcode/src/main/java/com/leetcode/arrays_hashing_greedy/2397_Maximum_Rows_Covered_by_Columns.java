package com.leetcode.arrays_hashing_greedy;

class Solution2397 {
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    rows[i] |= 1 << j;
                }
            }
        }
        int ans = 0;
        for (int mask = 1; mask < 1 << n; ++mask) {
            if (Integer.bitCount(mask) != numSelect) {
                continue;
            }
            int t = 0;
            for (int x : rows) {
                if ((x & mask) == x) {
                    ++t;
                }
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2397 _tcSol = new Solution2397();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[0,0,0],[1,0,1],[0,1,1],[0,0,1]], numSelect = 2");
        try {
            int[][] matrix = new int[][]{new int[]{0, 0, 0}, new int[]{1, 0, 1}, new int[]{0, 1, 1}, new int[]{0, 0, 1}};
            int numSelect = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumRows(matrix, numSelect)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[1],[0]], numSelect = 1");
        try {
            int[][] matrix = new int[][]{new int[]{1}, new int[]{0}};
            int numSelect = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumRows(matrix, numSelect)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}