package com.leetcode.matrices_grids;

class Solution0498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int idx = 0;
        List<Integer> t = new ArrayList<>();
        for (int k = 0; k < m + n - 1; ++k) {
            int i = k < n ? 0 : k - n + 1;
            int j = k < n ? k : n - 1;
            while (i < m && j >= 0) {
                t.add(mat[i][j]);
                ++i;
                --j;
            }
            if (k % 2 == 0) {
                Collections.reverse(t);
            }
            for (int v : t) {
                ans[idx++] = v;
            }
            t.clear();
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0498 _tcSol = new Solution0498();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,2,3],[4,5,6],[7,8,9]]");
        try {
            int[][] mat = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDiagonalOrder(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,4,7,5,3,6,8,9]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[1,2],[3,4]]");
        try {
            int[][] mat = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDiagonalOrder(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,4]");
        System.out.println();
    }
}