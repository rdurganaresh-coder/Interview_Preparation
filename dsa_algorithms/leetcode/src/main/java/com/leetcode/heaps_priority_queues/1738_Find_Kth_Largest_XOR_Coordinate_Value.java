package com.leetcode.heaps_priority_queues;

class Solution1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] s = new int[m + 1][n + 1];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                s[i + 1][j + 1] = s[i + 1][j] ^ s[i][j + 1] ^ s[i][j] ^ matrix[i][j];
                ans.add(s[i + 1][j + 1]);
            }
        }
        Collections.sort(ans);
        return ans.get(ans.size() - k);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1738 _tcSol = new Solution1738();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[5,2],[1,6]], k = 1");
        try {
            int[][] matrix = new int[][]{new int[]{5, 2}, new int[]{1, 6}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthLargestValue(matrix, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[5,2],[1,6]], k = 2");
        try {
            int[][] matrix = new int[][]{new int[]{5, 2}, new int[]{1, 6}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthLargestValue(matrix, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "matrix = [[5,2],[1,6]], k = 3");
        try {
            int[][] matrix = new int[][]{new int[]{5, 2}, new int[]{1, 6}};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthLargestValue(matrix, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}