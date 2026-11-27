package com.leetcode.arrays_hashing_greedy;

class Solution0733 {
    private int[][] image;
    private int oc;
    private int color;
    private final int[] dirs = {-1, 0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        oc = image[sr][sc];
        if (oc == color) {
            return image;
        }
        this.image = image;
        this.color = color;
        dfs(sr, sc);
        return image;
    }

    private void dfs(int i, int j) {
        image[i][j] = color;
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == oc) {
                dfs(x, y);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0733 _tcSol = new Solution0733();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2");
        try {
            int[][] image = new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 1}};
            int sr = 1;
            int sc = 1;
            int color = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.floodFill(image, sr, sc, color)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,2,2],[2,2,0],[2,0,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0");
        try {
            int[][] image = new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}};
            int sr = 0;
            int sc = 0;
            int color = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.floodFill(image, sr, sc, color)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0,0],[0,0,0]]");
        System.out.println();
    }
}
