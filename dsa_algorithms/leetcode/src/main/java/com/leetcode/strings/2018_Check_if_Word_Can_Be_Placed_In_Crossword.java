package com.leetcode.strings;

class Solution2018 {
    private int m;
    private int n;
    private char[][] board;
    private String word;
    private int k;

    public boolean placeWordInCrossword(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        this.word = word;
        k = word.length();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                boolean leftToRight = (j == 0 || board[i][j - 1] == '#') && check(i, j, 0, 1);
                boolean rightToLeft = (j == n - 1 || board[i][j + 1] == '#') && check(i, j, 0, -1);
                boolean upToDown = (i == 0 || board[i - 1][j] == '#') && check(i, j, 1, 0);
                boolean downToUp = (i == m - 1 || board[i + 1][j] == '#') && check(i, j, -1, 0);
                if (leftToRight || rightToLeft || upToDown || downToUp) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(int i, int j, int a, int b) {
        int x = i + a * k, y = j + b * k;
        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] != '#') {
            return false;
        }
        for (int p = 0; p < k; ++p) {
            if (i < 0 || i >= m || j < 0 || j >= n
                || (board[i][j] != ' ' && board[i][j] != word.charAt(p))) {
                return false;
            }
            i += a;
            j += b;
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2018 _tcSol = new Solution2018();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[\"#\", \" \", \"#\"], [\" \", \" \", \"#\"], [\"#\", \"c\", \" \"]], word = \"abc\"");
        try {
            char[][] board = new char[][]{new char[]{'#', ' ', '#'}, new char[]{' ', ' ', '#'}, new char[]{'#', 'c', ' '}};
            String word = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.placeWordInCrossword(board, word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[\" \", \"#\", \"a\"], [\" \", \"#\", \"c\"], [\" \", \"#\", \"a\"]], word = \"ac\"");
        try {
            char[][] board = new char[][]{new char[]{' ', '#', 'a'}, new char[]{' ', '#', 'c'}, new char[]{' ', '#', 'a'}};
            String word = "ac";
            System.out.println("  Output  : " + _tcShow(_tcSol.placeWordInCrossword(board, word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "board = [[\"#\", \" \", \"#\"], [\" \", \" \", \"#\"], [\"#\", \" \", \"c\"]], word = \"ca\"");
        try {
            char[][] board = new char[][]{new char[]{'#', ' ', '#'}, new char[]{' ', ' ', '#'}, new char[]{'#', ' ', 'c'}};
            String word = "ca";
            System.out.println("  Output  : " + _tcShow(_tcSol.placeWordInCrossword(board, word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}