package com.leetcode.arrays_hashing_greedy;

class Solution1275 {
    public String tictactoe(int[][] moves) {
        int n = moves.length;
        int[] cnt = new int[8];
        for (int k = n - 1; k >= 0; k -= 2) {
            int i = moves[k][0], j = moves[k][1];
            cnt[i]++;
            cnt[j + 3]++;
            if (i == j) {
                cnt[6]++;
            }
            if (i + j == 2) {
                cnt[7]++;
            }
            if (cnt[i] == 3 || cnt[j + 3] == 3 || cnt[6] == 3 || cnt[7] == 3) {
                return k % 2 == 0 ? "A" : "B";
            }
        }
        return n == 9 ? "Draw" : "Pending";
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1275 _tcSol = new Solution1275();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]");
        try {
            int[][] moves = new int[][]{new int[]{0, 0}, new int[]{2, 0}, new int[]{1, 1}, new int[]{2, 1}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.tictactoe(moves)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"A\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]");
        try {
            int[][] moves = new int[][]{new int[]{0, 0}, new int[]{1, 1}, new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 0}, new int[]{2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.tictactoe(moves)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"B\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]");
        try {
            int[][] moves = new int[][]{new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 0}, new int[]{1, 0}, new int[]{1, 2}, new int[]{2, 1}, new int[]{0, 1}, new int[]{0, 2}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.tictactoe(moves)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Draw\"");
        System.out.println();
    }
}