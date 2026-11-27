package com.leetcode.backtracking;

class Solution0036 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] sub = new boolean[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int num = c - '0' - 1;
                int k = i / 3 * 3 + j / 3;
                if (row[i][num] || col[j][num] || sub[k][num]) {
                    return false;
                }
                row[i][num] = true;
                col[j][num] = true;
                sub[k][num] = true;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0036 _tcSol = new Solution0036();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"] ,[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"] ,[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"] ,[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"] ,[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"] ,[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"] ,[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"] ,[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"] ,[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
        try {
            char[][] board = new char[][]{new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'}, new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'}, new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'}, new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'}, new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'}, new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'}, new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'}, new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isValidSudoku(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"] ,[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"] ,[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"] ,[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"] ,[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"] ,[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"] ,[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"] ,[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"] ,[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
        try {
            char[][] board = new char[][]{new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'}, new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'}, new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'}, new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'}, new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'}, new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'}, new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'}, new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isValidSudoku(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}