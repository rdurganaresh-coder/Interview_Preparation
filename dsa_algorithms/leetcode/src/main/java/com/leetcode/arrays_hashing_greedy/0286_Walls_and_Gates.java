package com.leetcode.arrays_hashing_greedy;

class Solution0286 {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Deque<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int d = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            ++d;
            for (int i = q.size(); i > 0; --i) {
                int[] p = q.poll();
                for (int j = 0; j < 4; ++j) {
                    int x = p[0] + dirs[j];
                    int y = p[1] + dirs[j + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == Integer.MAX_VALUE) {
                        rooms[x][y] = d;
                        q.offer(new int[] {x, y});
                    }
                }
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0286 _tcSol = new Solution0286();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]");
        try {
            int[][] rooms = new int[][]{new int[]{2147483647, -1, 0, 2147483647}, new int[]{2147483647, 2147483647, 2147483647, -1}, new int[]{2147483647, -1, 2147483647, -1}, new int[]{0, -1, 2147483647, 2147483647}};
            _tcSol.wallsAndGates(rooms);
            System.out.println("  Output  : " + _tcShow(rooms));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rooms = [[-1]]");
        try {
            int[][] rooms = new int[][]{new int[]{-1}};
            _tcSol.wallsAndGates(rooms);
            System.out.println("  Output  : " + _tcShow(rooms));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[-1]]");
        System.out.println();
    }
}