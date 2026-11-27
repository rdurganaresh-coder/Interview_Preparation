package com.leetcode.arrays_hashing_greedy;

class Solution2061 {
    private boolean[][][] vis;
    private int[][] room;
    private int ans;

    public int numberOfCleanRooms(int[][] room) {
        vis = new boolean[room.length][room[0].length][4];
        this.room = room;
        dfs(0, 0, 0);
        return ans;
    }

    private void dfs(int i, int j, int k) {
        if (vis[i][j][k]) {
            return;
        }
        int[] dirs = {0, 1, 0, -1, 0};
        ans += room[i][j] == 0 ? 1 : 0;
        room[i][j] = -1;
        vis[i][j][k] = true;
        int x = i + dirs[k], y = j + dirs[k + 1];
        if (x >= 0 && x < room.length && y >= 0 && y < room[0].length && room[x][y] != 1) {
            dfs(x, y, k);
        } else {
            dfs(i, j, (k + 1) % 4);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2061 _tcSol = new Solution2061();
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