package com.leetcode.arrays_hashing_greedy;

class Solution1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        for (int i = 0; i < arr.length;) {
            int k = 0;
            while (k < pieces.length && pieces[k][0] != arr[i]) {
                ++k;
            }
            if (k == pieces.length) {
                return false;
            }
            int j = 0;
            while (j < pieces[k].length && arr[i] == pieces[k][j]) {
                ++i;
                ++j;
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
        Solution1640 _tcSol = new Solution1640();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [15,88], pieces = [[88],[15]]");
        try {
            int[] arr = new int[]{15, 88};
            int[][] pieces = new int[][]{new int[]{88}, new int[]{15}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canFormArray(arr, pieces)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [49,18,16], pieces = [[16,18,49]]");
        try {
            int[] arr = new int[]{49, 18, 16};
            int[][] pieces = new int[][]{new int[]{16, 18, 49}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canFormArray(arr, pieces)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [91,4,64,78], pieces = [[78],[4,64],[91]]");
        try {
            int[] arr = new int[]{91, 4, 64, 78};
            int[][] pieces = new int[][]{new int[]{78}, new int[]{4, 64}, new int[]{91}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canFormArray(arr, pieces)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}