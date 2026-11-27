package com.leetcode.arrays_hashing_greedy;

class Solution0130_2 {
    private int[] p;

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        p = new int[m * n + 1];
        for (int i = 0; i < p.length; ++i) {
            p[i] = i;
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        p[find(i * n + j)] = find(m * n);
                    } else {
                        for (int k = 0; k < 4; ++k) {
                            int x = i + dirs[k];
                            int y = j + dirs[k + 1];
                            if (board[x][y] == 'O') {
                                p[find(x * n + y)] = find(i * n + j);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O' && find(i * n + j) != find(m * n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0130_2 _tcSol = new Solution0130_2();
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