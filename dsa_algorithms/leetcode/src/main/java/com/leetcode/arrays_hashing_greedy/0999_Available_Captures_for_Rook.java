package com.leetcode.arrays_hashing_greedy;

class Solution0999 {
    public int numRookCaptures(char[][] board) {
        final int[] dirs = {-1, 0, 1, 0, -1};
        int n = board.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'R') {
                    int ans = 0;
                    for (int k = 0; k < 4; ++k) {
                        int x = i + dirs[k], y = j + dirs[k + 1];
                        while (x >= 0 && x < n && y >= 0 && y < n && board[x][y] != 'B') {
                            if (board[x][y] == 'p') {
                                ++ans;
                                break;
                            }
                            x += dirs[k];
                            y += dirs[k + 1];
                        }
                    }
                    return ans;
                }
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0999 _tcSol = new Solution0999();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"p\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"R\",\".\",\".\",\".\",\"p\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"p\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"]]");
        try {
            char[][] board = new char[][]{new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'R', '.', '.', '.', 'p'}, new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'}, new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numRookCaptures(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\"p\",\"p\",\"p\",\"p\",\"p\",\".\",\".\"],[\".\",\"p\",\"p\",\"B\",\"p\",\"p\",\".\",\".\"],[\".\",\"p\",\"B\",\"R\",\"B\",\"p\",\".\",\".\"],[\".\",\"p\",\"p\",\"B\",\"p\",\"p\",\".\",\".\"],[\".\",\"p\",\"p\",\"p\",\"p\",\"p\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"]]");
        try {
            char[][] board = new char[][]{new char[]{'.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', 'p', 'p', 'p', 'p', 'p', '.', '.'}, new char[]{'.', 'p', 'p', 'B', 'p', 'p', '.', '.'}, new char[]{'.', 'p', 'B', 'R', 'B', 'p', '.', '.'}, new char[]{'.', 'p', 'p', 'B', 'p', 'p', '.', '.'}, new char[]{'.', 'p', 'p', 'p', 'p', 'p', '.', '.'}, new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numRookCaptures(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "board = [[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"p\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"p\",\".\",\".\",\".\",\".\"],[\"p\",\"p\",\".\",\"R\",\".\",\"p\",\"B\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"B\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"p\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"]]");
        try {
            char[][] board = new char[][]{new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'}, new char[]{'p', 'p', '.', 'R', '.', 'p', 'B', '.'}, new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'B', '.', '.', '.', '.'}, new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'}, new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numRookCaptures(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
