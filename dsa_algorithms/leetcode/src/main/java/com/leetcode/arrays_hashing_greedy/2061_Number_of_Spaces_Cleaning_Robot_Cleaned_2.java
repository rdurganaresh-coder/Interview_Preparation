package com.leetcode.arrays_hashing_greedy;

class Solution2061_2 {
    public int numberOfCleanRooms(int[][] room) {
        int[] dirs = {0, 1, 0, -1, 0};
        int i = 0, j = 0, k = 0;
        int m = room.length, n = room[0].length;
        boolean[][][] vis = new boolean[m][n][4];
        int ans = 0;
        while (!vis[i][j][k]) {
            vis[i][j][k] = true;
            ans += room[i][j] == 0 ? 1 : 0;
            room[i][j] = -1;
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && room[x][y] != 1) {
                i = x;
                j = y;
            } else {
                k = (k + 1) % 4;
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
        Solution2061_2 _tcSol = new Solution2061_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "room = [[0,0,0],[1,1,0],[0,0,0]]");
        try {
            int[][] room = new int[][]{new int[]{0, 0, 0}, new int[]{1, 1, 0}, new int[]{0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfCleanRooms(room)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "room = [[0,1,0],[1,0,0],[0,0,0]]");
        try {
            int[][] room = new int[][]{new int[]{0, 1, 0}, new int[]{1, 0, 0}, new int[]{0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfCleanRooms(room)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}