package com.leetcode.design_data_structures;

class TicTacToe0348 {
    private int n;
    private int[][] cnt;

    public TicTacToe0348(int n) {
        this.n = n;
        cnt = new int[2][(n << 1) + 2];
    }

    public int move(int row, int col, int player) {
        int[] cur = cnt[player - 1];
        ++cur[row];
        ++cur[n + col];
        if (row == col) {
            ++cur[n << 1];
        }
        if (row + col == n - 1) {
            ++cur[n << 1 | 1];
        }
        if (cur[row] == n || cur[n + col] == n || cur[n << 1] == n || cur[n << 1 | 1] == n) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe0348 object will be instantiated and called as such:
 * TicTacToe0348 obj = new TicTacToe0348(n);
 * int param_1 = obj.move(row,col,player);
 */