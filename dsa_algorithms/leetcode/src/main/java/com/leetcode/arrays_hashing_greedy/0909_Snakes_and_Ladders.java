package com.leetcode.arrays_hashing_greedy;

class Solution0909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        int m = n * n;
        boolean[] vis = new boolean[m + 1];
        vis[1] = true;
        for (int ans = 0; !q.isEmpty(); ++ans) {
            for (int k = q.size(); k > 0; --k) {
                int x = q.poll();
                if (x == m) {
                    return ans;
                }
                for (int y = x + 1; y <= Math.min(x + 6, m); ++y) {
                    int i = (y - 1) / n, j = (y - 1) % n;
                    if (i % 2 == 1) {
                        j = n - j - 1;
                    }
                    i = n - i - 1;
                    int z = board[i][j] == -1 ? y : board[i][j];
                    if (!vis[z]) {
                        vis[z] = true;
                        q.offer(z);
                    }
                }
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0909 _tcSol = new Solution0909();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]");
        try {
            int[][] board = new int[][]{new int[]{-1, -1, -1, -1, -1, -1}, new int[]{-1, -1, -1, -1, -1, -1}, new int[]{-1, -1, -1, -1, -1, -1}, new int[]{-1, 35, -1, -1, 13, -1}, new int[]{-1, -1, -1, -1, -1, -1}, new int[]{-1, 15, -1, -1, -1, -1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.snakesAndLadders(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "board = [[-1,-1],[-1,3]]");
        try {
            int[][] board = new int[][]{new int[]{-1, -1}, new int[]{-1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.snakesAndLadders(board)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}