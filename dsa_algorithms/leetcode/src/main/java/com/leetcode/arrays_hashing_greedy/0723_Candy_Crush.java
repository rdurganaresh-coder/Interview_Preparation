package com.leetcode.arrays_hashing_greedy;

class Solution0723 {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean run = true;

        while (run) {
            run = false;
            for (int i = 0; i < m; i++) {
                for (int j = 2; j < n; j++) {
                    if (board[i][j] != 0 && Math.abs(board[i][j]) == Math.abs(board[i][j - 1])
                        && Math.abs(board[i][j]) == Math.abs(board[i][j - 2])) {
                        run = true;
                        int val = Math.abs(board[i][j]);
                        board[i][j] = board[i][j - 1] = board[i][j - 2] = -val;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                for (int i = 2; i < m; i++) {
                    if (board[i][j] != 0 && Math.abs(board[i][j]) == Math.abs(board[i - 1][j])
                        && Math.abs(board[i][j]) == Math.abs(board[i - 2][j])) {
                        run = true;
                        int val = Math.abs(board[i][j]);
                        board[i][j] = board[i - 1][j] = board[i - 2][j] = -val;
                    }
                }
            }
            if (run) {
                for (int j = 0; j < n; j++) {
                    int k = m - 1;
                    for (int i = m - 1; i >= 0; i--) {
                        if (board[i][j] > 0) {
                            board[k][j] = board[i][j];
                            k--;
                        }
                    }
                    while (k >= 0) {
                        board[k][j] = 0;
                        k--;
                    }
                }
            }
        }

        return board;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0723 _tcSol = new Solution0723();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],[610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]");
        try {
            int[][] board = new int[][]{new int[]{110, 5, 112, 113, 114}, new int[]{210, 211, 5, 213, 214}, new int[]{310, 311, 3, 313, 314}, new int[]{410, 411, 412, 5, 414}, new int[]{5, 1, 512, 3, 3}, new int[]{610, 4, 1, 613, 614}, new int[]{710, 1, 2, 713, 714}, new int[]{810, 1, 2, 1, 1}, new int[]{1, 1, 2, 2, 2}, new int[]{4, 1, 4, 4, 1014}};
            System.out.println("  Output  : " + _tcShow(_tcSol.candyCrush(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],[410,0,0,213,414],[610,211,112,313,614],[710,311,412,613,714],[810,411,512,713,1014]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[1,3,5,5,2],[3,4,3,3,1],[3,2,4,5,2],[2,4,4,5,5],[1,4,4,1,1]]");
        try {
            int[][] board = new int[][]{new int[]{1, 3, 5, 5, 2}, new int[]{3, 4, 3, 3, 1}, new int[]{3, 2, 4, 5, 2}, new int[]{2, 4, 4, 5, 5}, new int[]{1, 4, 4, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.candyCrush(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,3,0,0,0],[3,4,0,5,2],[3,2,0,3,1],[2,4,0,5,2],[1,4,3,1,1]]");
        System.out.println();
    }
}