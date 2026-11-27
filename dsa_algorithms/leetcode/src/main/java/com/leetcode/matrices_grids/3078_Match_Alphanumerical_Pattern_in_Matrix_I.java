package com.leetcode.matrices_grids;

class Solution3078 {
    public int[] findPattern(int[][] board, String[] pattern) {
        int m = board.length, n = board[0].length;
        int r = pattern.length, c = pattern[0].length();
        for (int i = 0; i < m - r + 1; ++i) {
            for (int j = 0; j < n - c + 1; ++j) {
                if (check(board, pattern, i, j)) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    private boolean check(int[][] board, String[] pattern, int i, int j) {
        int[] d1 = new int[26];
        int[] d2 = new int[10];
        Arrays.fill(d1, -1);
        Arrays.fill(d2, -1);
        for (int a = 0; a < pattern.length; ++a) {
            for (int b = 0; b < pattern[0].length(); ++b) {
                int x = i + a, y = j + b;
                if (Character.isDigit(pattern[a].charAt(b))) {
                    int v = pattern[a].charAt(b) - '0';
                    if (v != board[x][y]) {
                        return false;
                    }
                } else {
                    int v = pattern[a].charAt(b) - 'a';
                    if (d1[v] != -1 && d1[v] != board[x][y]) {
                        return false;
                    }
                    if (d2[board[x][y]] != -1 && d2[board[x][y]] != v) {
                        return false;
                    }
                    d1[v] = board[x][y];
                    d2[board[x][y]] = v;
                }
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
        Solution3078 _tcSol = new Solution3078();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[1,2,2],[2,2,3],[2,3,3]], pattern = [\"ab\",\"bb\"]");
        try {
            int[][] board = new int[][]{new int[]{1, 2, 2}, new int[]{2, 2, 3}, new int[]{2, 3, 3}};
            String[] pattern = new String[]{"ab", "bb"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findPattern(board, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[1,1,2],[3,3,4],[6,6,6]], pattern = [\"ab\",\"66\"]");
        try {
            int[][] board = new int[][]{new int[]{1, 1, 2}, new int[]{3, 3, 4}, new int[]{6, 6, 6}};
            String[] pattern = new String[]{"ab", "66"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findPattern(board, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "board = [[1,2],[2,1]], pattern = [\"xx\"]");
        try {
            int[][] board = new int[][]{new int[]{1, 2}, new int[]{2, 1}};
            String[] pattern = new String[]{"xx"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findPattern(board, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1]");
        System.out.println();
    }
}