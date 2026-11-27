package com.leetcode.arrays_hashing_greedy;

class Solution1958 {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        for (int a = -1; a <= 1; ++a) {
            for (int b = -1; b <= 1; ++b) {
                if (a == 0 && b == 0) {
                    continue;
                }
                int i = rMove, j = cMove;
                int cnt = 0;
                while (0 <= i + a && i + a < 8 && 0 <= j + b && j + b < 8) {
                    i += a;
                    j += b;
                    if (++cnt > 1 && board[i][j] == color) {
                        return true;
                    }
                    if (board[i][j] == color || board[i][j] == '.') {
                        break;
                    }
                }
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1958 _tcSol = new Solution1958();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[\".\",\".\",\".\",\"B\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"W\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"W\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"W\",\".\",\".\",\".\",\".\"],[\"W\",\"B\",\"B\",\".\",\"W\",\"W\",\"W\",\"B\"],[\".\",\".\",\".\",\"B\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"B\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"W\",\".\",\".\",\".\",\".\"]], rMove = 4, cMove = 3, color = \"B\"");
        try {
            char[][] board = new char[][]{new char[]{'.', '.', '.', 'B', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'W', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'W', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'W', '.', '.', '.', '.'}, new char[]{'W', 'B', 'B', '.', 'W', 'W', 'W', 'B'}, new char[]{'.', '.', '.', 'B', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'B', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'W', '.', '.', '.', '.'}};
            int rMove = 4;
            int cMove = 3;
            char color = 'B';
            System.out.println("  Output  : " + _tcShow(_tcSol.checkMove(board, rMove, cMove, color)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\"B\",\".\",\".\",\"W\",\".\",\".\",\".\"],[\".\",\".\",\"W\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"W\",\"B\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\"B\",\"W\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\"W\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\"B\"]], rMove = 4, cMove = 4, color = \"W\"");
        try {
            char[][] board = new char[][]{new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', 'B', '.', '.', 'W', '.', '.', '.'}, new char[]{'.', '.', 'W', '.', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'W', 'B', '.', '.', '.'}, new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', '.', '.', '.', 'B', 'W', '.', '.'}, new char[]{'.', '.', '.', '.', '.', '.', 'W', '.'}, new char[]{'.', '.', '.', '.', '.', '.', '.', 'B'}};
            int rMove = 4;
            int cMove = 4;
            char color = 'W';
            System.out.println("  Output  : " + _tcShow(_tcSol.checkMove(board, rMove, cMove, color)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}