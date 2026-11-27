package com.leetcode.arrays_hashing_greedy;

class Solution3332 {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int[][] f = new int[k + 1][n];
        for (var g : f) {
            Arrays.fill(g, Integer.MIN_VALUE);
        }
        Arrays.fill(f[0], 0);
        for (int i = 1; i <= k; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int h = 0; h < n; ++h) {
                    f[i][j] = Math.max(
                        f[i][j], f[i - 1][h] + (j == h ? stayScore[i - 1][j] : travelScore[h][j]));
                }
            }
        }
        return Arrays.stream(f[k]).max().getAsInt();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3332 _tcSol = new Solution3332();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, k = 1, stayScore = [[2,3]], travelScore = [[0,2],[1,0]]");
        try {
            int n = 2;
            int k = 1;
            int[][] stayScore = new int[][]{new int[]{2, 3}};
            int[][] travelScore = new int[][]{new int[]{0, 2}, new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(n, k, stayScore, travelScore)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, k = 2, stayScore = [[3,4,2],[2,1,2]], travelScore = [[0,2,1],[2,0,4],[3,2,0]]");
        try {
            int n = 3;
            int k = 2;
            int[][] stayScore = new int[][]{new int[]{3, 4, 2}, new int[]{2, 1, 2}};
            int[][] travelScore = new int[][]{new int[]{0, 2, 1}, new int[]{2, 0, 4}, new int[]{3, 2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(n, k, stayScore, travelScore)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}
