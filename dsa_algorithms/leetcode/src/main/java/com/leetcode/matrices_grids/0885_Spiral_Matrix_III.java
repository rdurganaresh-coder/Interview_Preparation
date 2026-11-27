package com.leetcode.matrices_grids;

class Solution0885 {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int cnt = rows * cols;
        int[][] ans = new int[cnt][2];
        ans[0] = new int[] {rStart, cStart};
        if (cnt == 1) {
            return ans;
        }
        for (int k = 1, idx = 1;; k += 2) {
            int[][] dirs = new int[][] {{0, 1, k}, {1, 0, k}, {0, -1, k + 1}, {-1, 0, k + 1}};
            for (int[] dir : dirs) {
                int r = dir[0], c = dir[1], dk = dir[2];
                while (dk-- > 0) {
                    rStart += r;
                    cStart += c;
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        ans[idx++] = new int[] {rStart, cStart};
                        if (idx == cnt) {
                            return ans;
                        }
                    }
                }
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0885 _tcSol = new Solution0885();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rows = 1, cols = 4, rStart = 0, cStart = 0");
        try {
            int rows = 1;
            int cols = 4;
            int rStart = 0;
            int cStart = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.spiralMatrixIII(rows, cols, rStart, cStart)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0],[0,1],[0,2],[0,3]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rows = 5, cols = 6, rStart = 1, cStart = 4");
        try {
            int rows = 5;
            int cols = 6;
            int rStart = 1;
            int cStart = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.spiralMatrixIII(rows, cols, rStart, cStart)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]");
        System.out.println();
    }
}