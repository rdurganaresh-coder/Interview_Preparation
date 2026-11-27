package com.leetcode.matrices_grids;

class Solution2713 {
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        TreeMap<Integer, List<int[]>> g = new TreeMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                g.computeIfAbsent(mat[i][j], k -> new ArrayList<>()).add(new int[] {i, j});
            }
        }
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        int ans = 0;
        for (var e : g.entrySet()) {
            var pos = e.getValue();
            int[] mx = new int[pos.size()];
            int k = 0;
            for (var p : pos) {
                int i = p[0], j = p[1];
                mx[k] = Math.max(rowMax[i], colMax[j]) + 1;
                ans = Math.max(ans, mx[k++]);
            }
            for (k = 0; k < mx.length; ++k) {
                int i = pos.get(k)[0], j = pos.get(k)[1];
                rowMax[i] = Math.max(rowMax[i], mx[k]);
                colMax[j] = Math.max(colMax[j], mx[k]);
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
        Solution2713 _tcSol = new Solution2713();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[3,1],[3,4]]");
        try {
            int[][] mat = new int[][]{new int[]{3, 1}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIncreasingCells(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[1,1],[1,1]]");
        try {
            int[][] mat = new int[][]{new int[]{1, 1}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIncreasingCells(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "mat = [[3,1,6],[-9,5,7]]");
        try {
            int[][] mat = new int[][]{new int[]{3, 1, 6}, new int[]{-9, 5, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIncreasingCells(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}