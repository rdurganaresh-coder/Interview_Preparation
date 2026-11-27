package com.leetcode.arrays_hashing_greedy;

class Solution0289 {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int live = -board[i][j];
                for (int x = i - 1; x <= i + 1; ++x) {
                    for (int y = j - 1; y <= j + 1; ++y) {
                        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] > 0) {
                            ++live;
                        }
                    }
                }
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
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
        Solution0289 _tcSol = new Solution0289();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]");
        try {
            int[][] board = new int[][]{new int[]{0, 1, 0}, new int[]{0, 0, 1}, new int[]{1, 1, 1}, new int[]{0, 0, 0}};
            _tcSol.gameOfLife(board);
            System.out.println("  Output  : " + _tcShow(board));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[1,1],[1,0]]");
        try {
            int[][] board = new int[][]{new int[]{1, 1}, new int[]{1, 0}};
            _tcSol.gameOfLife(board);
            System.out.println("  Output  : " + _tcShow(board));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,1],[1,1]]");
        System.out.println();
    }
}