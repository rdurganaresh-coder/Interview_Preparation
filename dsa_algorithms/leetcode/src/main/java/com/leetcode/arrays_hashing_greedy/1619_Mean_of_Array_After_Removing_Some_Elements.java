package com.leetcode.arrays_hashing_greedy;

class Solution1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        double s = 0;
        for (int start = (int) (n * 0.05), i = start; i < n - start; ++i) {
            s += arr[i];
        }
        return s / (n * 0.9);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1619 _tcSol = new Solution1619();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]");
        try {
            int[] arr = new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.trimMean(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]");
        try {
            int[] arr = new int[]{6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.trimMean(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4.00000");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]");
        try {
            int[] arr = new int[]{6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.trimMean(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4.77778");
        System.out.println();
    }
}