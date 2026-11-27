package com.leetcode.sliding_window_two_pointers;

class Solution0778 {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = n * n;
        int[] p = new int[m];
        Arrays.setAll(p, i -> i);
        IntUnaryOperator find = new IntUnaryOperator() {
            @Override
            public int applyAsInt(int x) {
                if (p[x] != x) p[x] = applyAsInt(p[x]);
                return p[x];
            }
        };

        int[] hi = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hi[grid[i][j]] = i * n + j;
            }
        }

        int[] dirs = {-1, 0, 1, 0, -1};

        for (int t = 0; t < m; t++) {
            int id = hi[t];
            int x = id / n, y = id % n;
            for (int k = 0; k < 4; k++) {
                int nx = x + dirs[k], ny = y + dirs[k + 1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] <= t) {
                    int a = find.applyAsInt(x * n + y);
                    int b = find.applyAsInt(nx * n + ny);
                    p[a] = b;
                }
            }
            if (find.applyAsInt(0) == find.applyAsInt(m - 1)) {
                return t;
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
        Solution0778 _tcSol = new Solution0778();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[0,2],[1,3]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 2}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.swimInWater(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]");
        try {
            int[][] grid = new int[][]{new int[]{0, 1, 2, 3, 4}, new int[]{24, 23, 22, 21, 5}, new int[]{12, 13, 14, 15, 16}, new int[]{11, 17, 18, 19, 20}, new int[]{10, 9, 8, 7, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.swimInWater(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}
