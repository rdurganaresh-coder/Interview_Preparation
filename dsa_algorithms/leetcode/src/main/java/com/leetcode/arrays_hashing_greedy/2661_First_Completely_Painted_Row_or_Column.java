package com.leetcode.arrays_hashing_greedy;

class Solution2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, int[]> idx = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                idx.put(mat[i][j], new int[] {i, j});
            }
        }
        int[] row = new int[m];
        int[] col = new int[n];
        for (int k = 0;; ++k) {
            var x = idx.get(arr[k]);
            int i = x[0], j = x[1];
            ++row[i];
            ++col[j];
            if (row[i] == n || col[j] == m) {
                return k;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2661 _tcSol = new Solution2661();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,3,4,2], mat = [[1,4],[2,3]]");
        try {
            int[] arr = new int[]{1, 3, 4, 2};
            int[][] mat = new int[][]{new int[]{1, 4}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.firstCompleteIndex(arr, mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]");
        try {
            int[] arr = new int[]{2, 8, 7, 4, 1, 3, 5, 6, 9};
            int[][] mat = new int[][]{new int[]{3, 2, 5}, new int[]{1, 4, 6}, new int[]{8, 7, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.firstCompleteIndex(arr, mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}