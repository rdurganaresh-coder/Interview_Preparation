package com.leetcode.sliding_window_two_pointers;

class Solution1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int n = groups.length, m = nums.length;
        int i = 0;
        for (int j = 0; i < n && j < m;) {
            if (check(groups[i], nums, j)) {
                j += groups[i].length;
                ++i;
            } else {
                ++j;
            }
        }
        return i == n;
    }

    private boolean check(int[] a, int[] b, int j) {
        int m = a.length, n = b.length;
        int i = 0;
        for (; i < m && j < n; ++i, ++j) {
            if (a[i] != b[j]) {
                return false;
            }
        }
        return i == m;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1764 _tcSol = new Solution1764();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "groups = [[1,-1,-1],[3,-2,0]], nums = [1,-1,0,1,-1,-1,3,-2,0]");
        try {
            int[][] groups = new int[][]{new int[]{1, -1, -1}, new int[]{3, -2, 0}};
            int[] nums = new int[]{1, -1, 0, 1, -1, -1, 3, -2, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.canChoose(groups, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "groups = [[10,-2],[1,2,3,4]], nums = [1,2,3,4,10,-2]");
        try {
            int[][] groups = new int[][]{new int[]{10, -2}, new int[]{1, 2, 3, 4}};
            int[] nums = new int[]{1, 2, 3, 4, 10, -2};
            System.out.println("  Output  : " + _tcShow(_tcSol.canChoose(groups, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "groups = [[1,2,3],[3,4]], nums = [7,7,1,2,3,4,7,7]");
        try {
            int[][] groups = new int[][]{new int[]{1, 2, 3}, new int[]{3, 4}};
            int[] nums = new int[]{7, 7, 1, 2, 3, 4, 7, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.canChoose(groups, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}