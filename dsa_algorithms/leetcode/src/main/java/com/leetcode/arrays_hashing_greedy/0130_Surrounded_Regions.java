package com.leetcode.arrays_hashing_greedy;

class Solution0130 {
    private final int[] dirs = {-1, 0, 1, 0, -1};
    private char[][] board;
    private int m;
    private int n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        for (int i = 0; i < m; ++i) {
            dfs(i, 0);
            dfs(i, n - 1);
        }
        for (int j = 0; j < n; ++j) {
            dfs(0, j);
            dfs(m - 1, j);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '.';
        for (int k = 0; k < 4; ++k) {
            dfs(i + dirs[k], j + dirs[k + 1]);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0130 _tcSol = new Solution0130();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"O\",\"X\"],[\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]]");
        try {
            char[][] board = new char[][]{new char[]{'X', 'X', 'X', 'X'}, new char[]{'X', 'O', 'O', 'X'}, new char[]{'X', 'X', 'O', 'X'}, new char[]{'X', 'O', 'X', 'X'}};
            _tcSol.solve(board);
            System.out.println("  Output  : " + _tcShow(board));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[\"X\"]]");
        try {
            char[][] board = new char[][]{new char[]{'X'}};
            _tcSol.solve(board);
            System.out.println("  Output  : " + _tcShow(board));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"X\"]]");
        System.out.println();
    }
}