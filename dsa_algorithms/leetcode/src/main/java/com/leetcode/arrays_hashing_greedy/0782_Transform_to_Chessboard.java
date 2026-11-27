package com.leetcode.arrays_hashing_greedy;

class Solution0782 {
    private int n;

    public int movesToChessboard(int[][] board) {
        n = board.length;
        int mask = (1 << n) - 1;
        int rowMask = 0, colMask = 0;
        for (int i = 0; i < n; ++i) {
            rowMask |= board[0][i] << i;
            colMask |= board[i][0] << i;
        }
        int revRowMask = mask ^ rowMask;
        int revColMask = mask ^ colMask;
        int sameRow = 0, sameCol = 0;
        for (int i = 0; i < n; ++i) {
            int curRowMask = 0, curColMask = 0;
            for (int j = 0; j < n; ++j) {
                curRowMask |= board[i][j] << j;
                curColMask |= board[j][i] << j;
            }
            if (curRowMask != rowMask && curRowMask != revRowMask) {
                return -1;
            }
            if (curColMask != colMask && curColMask != revColMask) {
                return -1;
            }
            sameRow += curRowMask == rowMask ? 1 : 0;
            sameCol += curColMask == colMask ? 1 : 0;
        }
        int t1 = f(rowMask, sameRow);
        int t2 = f(colMask, sameCol);
        return t1 == -1 || t2 == -1 ? -1 : t1 + t2;
    }

    private int f(int mask, int cnt) {
        int ones = Integer.bitCount(mask);
        if (n % 2 == 1) {
            if (Math.abs(n - ones * 2) != 1 || Math.abs(n - cnt * 2) != 1) {
                return -1;
            }
            if (ones == n / 2) {
                return n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
            }
            return (n / 2 + 1) - Integer.bitCount(mask & 0x55555555);
        } else {
            if (ones != n / 2 || cnt != n / 2) {
                return -1;
            }
            int cnt0 = n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
            int cnt1 = n / 2 - Integer.bitCount(mask & 0x55555555);
            return Math.min(cnt0, cnt1);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0782 _tcSol = new Solution0782();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]");
        try {
            int[][] board = new int[][]{new int[]{0, 1, 1, 0}, new int[]{0, 1, 1, 0}, new int[]{1, 0, 0, 1}, new int[]{1, 0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.movesToChessboard(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[0,1],[1,0]]");
        try {
            int[][] board = new int[][]{new int[]{0, 1}, new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.movesToChessboard(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "board = [[1,0],[1,0]]");
        try {
            int[][] board = new int[][]{new int[]{1, 0}, new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.movesToChessboard(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}