package com.leetcode.matrices_grids;

class Solution0529 {
    private char[][] board;
    private int m;
    private int n;

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        int i = click[0], j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
        } else {
            dfs(i, j);
        }
        return board;
    }

    private void dfs(int i, int j) {
        int cnt = 0;
        for (int x = i - 1; x <= i + 1; ++x) {
            for (int y = j - 1; y <= j + 1; ++y) {
                if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'M') {
                    ++cnt;
                }
            }
        }
        if (cnt > 0) {
            board[i][j] = (char) (cnt + '0');
        } else {
            board[i][j] = 'B';
            for (int x = i - 1; x <= i + 1; ++x) {
                for (int y = j - 1; y <= j + 1; ++y) {
                    if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'E') {
                        dfs(x, y);
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
        Solution0529 _tcSol = new Solution0529();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[\"E\",\"E\",\"E\",\"E\",\"E\"],[\"E\",\"E\",\"M\",\"E\",\"E\"],[\"E\",\"E\",\"E\",\"E\",\"E\"],[\"E\",\"E\",\"E\",\"E\",\"E\"]], click = [3,0]");
        try {
            char[][] board = new char[][]{new char[]{'E', 'E', 'E', 'E', 'E'}, new char[]{'E', 'E', 'M', 'E', 'E'}, new char[]{'E', 'E', 'E', 'E', 'E'}, new char[]{'E', 'E', 'E', 'E', 'E'}};
            int[] click = new int[]{3, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.updateBoard(board, click)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"B\",\"1\",\"E\",\"1\",\"B\"],[\"B\",\"1\",\"M\",\"1\",\"B\"],[\"B\",\"1\",\"1\",\"1\",\"B\"],[\"B\",\"B\",\"B\",\"B\",\"B\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[\"B\",\"1\",\"E\",\"1\",\"B\"],[\"B\",\"1\",\"M\",\"1\",\"B\"],[\"B\",\"1\",\"1\",\"1\",\"B\"],[\"B\",\"B\",\"B\",\"B\",\"B\"]], click = [1,2]");
        try {
            char[][] board = new char[][]{new char[]{'B', '1', 'E', '1', 'B'}, new char[]{'B', '1', 'M', '1', 'B'}, new char[]{'B', '1', '1', '1', 'B'}, new char[]{'B', 'B', 'B', 'B', 'B'}};
            int[] click = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.updateBoard(board, click)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"B\",\"1\",\"E\",\"1\",\"B\"],[\"B\",\"1\",\"X\",\"1\",\"B\"],[\"B\",\"1\",\"1\",\"1\",\"B\"],[\"B\",\"B\",\"B\",\"B\",\"B\"]]");
        System.out.println();
    }
}