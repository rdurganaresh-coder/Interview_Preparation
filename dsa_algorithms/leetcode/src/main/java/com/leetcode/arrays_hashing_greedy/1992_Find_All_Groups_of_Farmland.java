package com.leetcode.arrays_hashing_greedy;

class Solution1992 {
    public int[][] findFarmland(int[][] land) {
        List<int[]> ans = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (land[i][j] == 0 || (j > 0 && land[i][j - 1] == 1)
                    || (i > 0 && land[i - 1][j] == 1)) {
                    continue;
                }
                int x = i;
                int y = j;
                for (; x + 1 < m && land[x + 1][j] == 1; ++x)
                    ;
                for (; y + 1 < n && land[x][y + 1] == 1; ++y)
                    ;
                ans.add(new int[] {i, j, x, y});
            }
        }
        return ans.toArray(new int[ans.size()][4]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1992 _tcSol = new Solution1992();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "land = [[1,0,0],[0,1,1],[0,1,1]]");
        try {
            int[][] land = new int[][]{new int[]{1, 0, 0}, new int[]{0, 1, 1}, new int[]{0, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findFarmland(land)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0,0,0],[1,1,2,2]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "land = [[1,1],[1,1]]");
        try {
            int[][] land = new int[][]{new int[]{1, 1}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findFarmland(land)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0,1,1]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "land = [[0]]");
        try {
            int[][] land = new int[][]{new int[]{0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findFarmland(land)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}