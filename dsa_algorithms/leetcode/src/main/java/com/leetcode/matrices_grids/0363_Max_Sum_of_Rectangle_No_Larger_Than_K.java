package com.leetcode.matrices_grids;

class Solution0363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        final int inf = 1 << 30;
        int ans = -inf;
        for (int i = 0; i < m; ++i) {
            int[] nums = new int[n];
            for (int j = i; j < m; ++j) {
                for (int h = 0; h < n; ++h) {
                    nums[h] += matrix[j][h];
                }
                int s = 0;
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                for (int x : nums) {
                    s += x;
                    Integer y = ts.ceiling(s - k);
                    if (y != null) {
                        ans = Math.max(ans, s - y);
                    }
                    ts.add(s);
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
        Solution0363 _tcSol = new Solution0363();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[1,0,1],[0,-2,3]], k = 2");
        try {
            int[][] matrix = new int[][]{new int[]{1, 0, 1}, new int[]{0, -2, 3}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumSubmatrix(matrix, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[2,2,-1]], k = 3");
        try {
            int[][] matrix = new int[][]{new int[]{2, 2, -1}};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumSubmatrix(matrix, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}