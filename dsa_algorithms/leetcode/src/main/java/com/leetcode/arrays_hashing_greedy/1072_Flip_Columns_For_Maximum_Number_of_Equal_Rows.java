package com.leetcode.arrays_hashing_greedy;

class Solution1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> cnt = new HashMap<>();
        int ans = 0, n = matrix[0].length;
        for (var row : matrix) {
            char[] cs = new char[n];
            for (int i = 0; i < n; ++i) {
                cs[i] = (char) (row[0] ^ row[i]);
            }
            ans = Math.max(ans, cnt.merge(String.valueOf(cs), 1, Integer::sum));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1072 _tcSol = new Solution1072();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[0,1],[1,1]]");
        try {
            int[][] matrix = new int[][]{new int[]{0, 1}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxEqualRowsAfterFlips(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[0,1],[1,0]]");
        try {
            int[][] matrix = new int[][]{new int[]{0, 1}, new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxEqualRowsAfterFlips(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "matrix = [[0,0,0],[0,0,1],[1,1,0]]");
        try {
            int[][] matrix = new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 1}, new int[]{1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxEqualRowsAfterFlips(matrix)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}