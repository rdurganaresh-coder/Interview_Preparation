package com.leetcode.arrays_hashing_greedy;

class Solution0835 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        Map<List<Integer>, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (img1[i][j] == 1) {
                    for (int h = 0; h < n; ++h) {
                        for (int k = 0; k < n; ++k) {
                            if (img2[h][k] == 1) {
                                List<Integer> t = List.of(i - h, j - k);
                                ans = Math.max(ans, cnt.merge(t, 1, Integer::sum));
                            }
                        }
                    }
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
        Solution0835 _tcSol = new Solution0835();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]");
        try {
            int[][] img1 = new int[][]{new int[]{1, 1, 0}, new int[]{0, 1, 0}, new int[]{0, 1, 0}};
            int[][] img2 = new int[][]{new int[]{0, 0, 0}, new int[]{0, 1, 1}, new int[]{0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestOverlap(img1, img2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "img1 = [[1]], img2 = [[1]]");
        try {
            int[][] img1 = new int[][]{new int[]{1}};
            int[][] img2 = new int[][]{new int[]{1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestOverlap(img1, img2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "img1 = [[0]], img2 = [[0]]");
        try {
            int[][] img1 = new int[][]{new int[]{0}};
            int[][] img2 = new int[][]{new int[]{0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestOverlap(img1, img2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}