package com.leetcode.binary_search;

class Solution1901 {
    public int[] findPeakGrid(int[][] mat) {
        int l = 0, r = mat.length - 1;
        int n = mat[0].length;
        while (l < r) {
            int mid = (l + r) >> 1;
            int j = maxPos(mat[mid]);
            if (mat[mid][j] > mat[mid + 1][j]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return new int[] {l, maxPos(mat[l])};
    }

    private int maxPos(int[] arr) {
        int j = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[j] < arr[i]) {
                j = i;
            }
        }
        return j;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1901 _tcSol = new Solution1901();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,4],[3,2]]");
        try {
            int[][] mat = new int[][]{new int[]{1, 4}, new int[]{3, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findPeakGrid(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[10,20,15],[21,30,14],[7,16,32]]");
        try {
            int[][] mat = new int[][]{new int[]{10, 20, 15}, new int[]{21, 30, 14}, new int[]{7, 16, 32}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findPeakGrid(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1]");
        System.out.println();
    }
}