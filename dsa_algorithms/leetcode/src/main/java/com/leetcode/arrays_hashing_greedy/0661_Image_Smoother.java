package com.leetcode.arrays_hashing_greedy;

class Solution0661 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int s = 0;
                int cnt = 0;
                for (int x = i - 1; x <= i + 1; ++x) {
                    for (int y = j - 1; y <= j + 1; ++y) {
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            ++cnt;
                            s += img[x][y];
                        }
                    }
                }
                ans[i][j] = s / cnt;
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
        Solution0661 _tcSol = new Solution0661();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "img = [[1,1,1],[1,0,1],[1,1,1]]");
        try {
            int[][] img = new int[][]{new int[]{1, 1, 1}, new int[]{1, 0, 1}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.imageSmoother(img)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0,0],[0,0,0],[0,0,0]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "img = [[100,200,100],[200,50,200],[100,200,100]]");
        try {
            int[][] img = new int[][]{new int[]{100, 200, 100}, new int[]{200, 50, 200}, new int[]{100, 200, 100}};
            System.out.println("  Output  : " + _tcShow(_tcSol.imageSmoother(img)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[137,141,137],[141,138,141],[137,141,137]]");
        System.out.println();
    }
}