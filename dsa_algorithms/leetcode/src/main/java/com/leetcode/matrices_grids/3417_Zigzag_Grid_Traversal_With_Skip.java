package com.leetcode.matrices_grids;

class Solution3417 {
    public List<Integer> zigzagTraversal(int[][] grid) {
        boolean ok = true;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < grid.length; ++i) {
            if (i % 2 == 1) {
                reverse(grid[i]);
            }
            for (int x : grid[i]) {
                if (ok) {
                    ans.add(x);
                }
                ok = !ok;
            }
        }
        return ans;
    }

    private void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; ++i, --j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3417 _tcSol = new Solution3417();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,2],[3,4]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.zigzagTraversal(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[2,1],[2,1],[2,1]]");
        try {
            int[][] grid = new int[][]{new int[]{2, 1}, new int[]{2, 1}, new int[]{2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.zigzagTraversal(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "grid = [[1,2,3],[4,5,6],[7,8,9]]");
        try {
            int[][] grid = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.zigzagTraversal(grid)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3,5,7,9]");
        System.out.println();
    }
}
