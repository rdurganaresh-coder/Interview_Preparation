package com.leetcode.arrays_hashing_greedy;

class Solution1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            int[] col = new int[n];
            for (int j = i; j < m; ++j) {
                for (int k = 0; k < n; ++k) {
                    col[k] += matrix[j][k];
                }
                ans += f(col, target);
            }
        }
        return ans;
    }

    private int f(int[] nums, int target) {
        Map<Integer, Integer> d = new HashMap<>();
        d.put(0, 1);
        int s = 0, cnt = 0;
        for (int x : nums) {
            s += x;
            cnt += d.getOrDefault(s - target, 0);
            d.merge(s, 1, Integer::sum);
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1074 _tcSol = new Solution1074();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0");
        try {
            int[][] matrix = new int[][]{new int[]{0, 1, 0}, new int[]{1, 1, 1}, new int[]{0, 1, 0}};
            int target = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubmatrixSumTarget(matrix, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "matrix = [[1,-1],[-1,1]], target = 0");
        try {
            int[][] matrix = new int[][]{new int[]{1, -1}, new int[]{-1, 1}};
            int target = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubmatrixSumTarget(matrix, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "matrix = [[904]], target = 0");
        try {
            int[][] matrix = new int[][]{new int[]{904}};
            int target = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubmatrixSumTarget(matrix, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}