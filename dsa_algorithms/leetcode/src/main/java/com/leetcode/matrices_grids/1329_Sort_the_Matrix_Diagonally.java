package com.leetcode.matrices_grids;

class Solution1329 {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<Integer>[] g = new List[m + n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                g[m - i + j].add(mat[i][j]);
            }
        }
        for (var e : g) {
            Collections.sort(e, (a, b) -> b - a);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                mat[i][j] = g[m - i + j].removeLast();
            }
        }
        return mat;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1329 _tcSol = new Solution1329();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]");
        try {
            int[][] mat = new int[][]{new int[]{3, 3, 1, 1}, new int[]{2, 2, 1, 2}, new int[]{1, 1, 1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.diagonalSort(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,1,1,1],[1,2,2,2],[1,2,3,3]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]");
        try {
            int[][] mat = new int[][]{new int[]{11, 25, 66, 1, 69, 7}, new int[]{23, 55, 17, 45, 15, 52}, new int[]{75, 31, 36, 44, 58, 8}, new int[]{22, 27, 33, 25, 68, 4}, new int[]{84, 28, 14, 11, 5, 50}};
            System.out.println("  Output  : " + _tcShow(_tcSol.diagonalSort(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]");
        System.out.println();
    }
}