package com.leetcode.matrices_grids;

class Solution0419 {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                ++ans;
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
        Solution0419 _tcSol = new Solution0419();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[\"X\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"]]");
        try {
            char[][] board = new char[][]{new char[]{'X', '.', '.', 'X'}, new char[]{'.', '.', '.', 'X'}, new char[]{'.', '.', '.', 'X'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countBattleships(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[\".\"]]");
        try {
            char[][] board = new char[][]{new char[]{'.'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countBattleships(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}