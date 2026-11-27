package com.leetcode.matrices_grids;

class Solution2679 {
    public int matrixSum(int[][] nums) {
        for (var row : nums) {
            Arrays.sort(row);
        }
        int ans = 0;
        for (int j = 0; j < nums[0].length; ++j) {
            int mx = 0;
            for (var row : nums) {
                mx = Math.max(mx, row[j]);
            }
            ans += mx;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2679 _tcSol = new Solution2679();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [[7,2,1],[6,4,2],[6,5,3],[3,2,1]]");
        try {
            int[][] nums = new int[][]{new int[]{7, 2, 1}, new int[]{6, 4, 2}, new int[]{6, 5, 3}, new int[]{3, 2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [[1]]");
        try {
            int[][] nums = new int[][]{new int[]{1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}