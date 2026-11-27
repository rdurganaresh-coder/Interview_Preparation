package com.leetcode.arrays_hashing_greedy;

class Solution1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int[] range : ranges) {
            int l = range[0], r = range[1];
            ++diff[l];
            --diff[r + 1];
        }
        int s = 0;
        for (int i = 0; i < diff.length; ++i) {
            s += diff[i];
            if (s <= 0 && left <= i && i <= right) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1893 _tcSol = new Solution1893();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5");
        try {
            int[][] ranges = new int[][]{new int[]{1, 2}, new int[]{3, 4}, new int[]{5, 6}};
            int left = 2;
            int right = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.isCovered(ranges, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "ranges = [[1,10],[10,20]], left = 21, right = 21");
        try {
            int[][] ranges = new int[][]{new int[]{1, 10}, new int[]{10, 20}};
            int left = 21;
            int right = 21;
            System.out.println("  Output  : " + _tcShow(_tcSol.isCovered(ranges, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}