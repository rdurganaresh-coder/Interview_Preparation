package com.leetcode.arrays_hashing_greedy;

class Solution0832 {
    public int[][] flipAndInvertImage(int[][] image) {
        for (var row : image) {
            int i = 0, j = row.length - 1;
            for (; i < j; ++i, --j) {
                if (row[i] == row[j]) {
                    row[i] ^= 1;
                    row[j] ^= 1;
                }
            }
            if (i == j) {
                row[i] ^= 1;
            }
        }
        return image;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0832 _tcSol = new Solution0832();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "image = [[1,1,0],[1,0,1],[0,0,0]]");
        try {
            int[][] image = new int[][]{new int[]{1, 1, 0}, new int[]{1, 0, 1}, new int[]{0, 0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.flipAndInvertImage(image)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,0,0],[0,1,0],[1,1,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]");
        try {
            int[][] image = new int[][]{new int[]{1, 1, 0, 0}, new int[]{1, 0, 0, 1}, new int[]{0, 1, 1, 1}, new int[]{1, 0, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.flipAndInvertImage(image)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]");
        System.out.println();
    }
}