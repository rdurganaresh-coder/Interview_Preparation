package com.leetcode.matrices_grids;

class Solution3030 {
    public int[][] resultGrid(int[][] image, int threshold) {
        int n = image.length;
        int m = image[0].length;
        int[][] ans = new int[n][m];
        int[][] ct = new int[n][m];
        for (int i = 0; i + 2 < n; ++i) {
            for (int j = 0; j + 2 < m; ++j) {
                boolean region = true;
                for (int k = 0; k < 3; ++k) {
                    for (int l = 0; l < 2; ++l) {
                        region
                            &= Math.abs(image[i + k][j + l] - image[i + k][j + l + 1]) <= threshold;
                    }
                }
                for (int k = 0; k < 2; ++k) {
                    for (int l = 0; l < 3; ++l) {
                        region
                            &= Math.abs(image[i + k][j + l] - image[i + k + 1][j + l]) <= threshold;
                    }
                }
                if (region) {
                    int tot = 0;
                    for (int k = 0; k < 3; ++k) {
                        for (int l = 0; l < 3; ++l) {
                            tot += image[i + k][j + l];
                        }
                    }
                    for (int k = 0; k < 3; ++k) {
                        for (int l = 0; l < 3; ++l) {
                            ct[i + k][j + l]++;
                            ans[i + k][j + l] += tot / 9;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (ct[i][j] == 0) {
                    ans[i][j] = image[i][j];
                } else {
                    ans[i][j] /= ct[i][j];
                }
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
        Solution3030 _tcSol = new Solution3030();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "image = [[5,6,7,10],[8,9,10,10],[11,12,13,10]], threshold = 3");
        try {
            int[][] image = new int[][]{new int[]{5, 6, 7, 10}, new int[]{8, 9, 10, 10}, new int[]{11, 12, 13, 10}};
            int threshold = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.resultGrid(image, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[9,9,9,9],[9,9,9,9],[9,9,9,9]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "image = [[10,20,30],[15,25,35],[20,30,40],[25,35,45]], threshold = 12");
        try {
            int[][] image = new int[][]{new int[]{10, 20, 30}, new int[]{15, 25, 35}, new int[]{20, 30, 40}, new int[]{25, 35, 45}};
            int threshold = 12;
            System.out.println("  Output  : " + _tcShow(_tcSol.resultGrid(image, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[25,25,25],[27,27,27],[27,27,27],[30,30,30]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "image = [[5,6,7],[8,9,10],[11,12,13]], threshold = 1");
        try {
            int[][] image = new int[][]{new int[]{5, 6, 7}, new int[]{8, 9, 10}, new int[]{11, 12, 13}};
            int threshold = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.resultGrid(image, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[5,6,7],[8,9,10],[11,12,13]]");
        System.out.println();
    }
}
