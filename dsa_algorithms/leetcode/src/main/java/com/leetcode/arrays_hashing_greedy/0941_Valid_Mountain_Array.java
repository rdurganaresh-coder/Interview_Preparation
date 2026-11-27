package com.leetcode.arrays_hashing_greedy;

class Solution0941 {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        int i = 0, j = n - 1;
        while (i + 1 < n - 1 && arr[i] < arr[i + 1]) {
            ++i;
        }
        while (j - 1 > 0 && arr[j - 1] > arr[j]) {
            --j;
        }
        return i == j;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0941 _tcSol = new Solution0941();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [2,1]");
        try {
            int[] arr = new int[]{2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.validMountainArray(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [3,5,5]");
        try {
            int[] arr = new int[]{3, 5, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.validMountainArray(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [0,3,2,1]");
        try {
            int[] arr = new int[]{0, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.validMountainArray(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}