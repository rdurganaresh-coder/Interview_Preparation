package com.leetcode.bit_manipulation_math;

class Solution1835 {
    public int getXORSum(int[] arr1, int[] arr2) {
        int a = 0, b = 0;
        for (int v : arr1) {
            a ^= v;
        }
        for (int v : arr2) {
            b ^= v;
        }
        return a & b;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1835 _tcSol = new Solution1835();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr1 = [1,2,3], arr2 = [6,5]");
        try {
            int[] arr1 = new int[]{1, 2, 3};
            int[] arr2 = new int[]{6, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.getXORSum(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr1 = [12], arr2 = [4]");
        try {
            int[] arr1 = new int[]{12};
            int[] arr2 = new int[]{4};
            System.out.println("  Output  : " + _tcShow(_tcSol.getXORSum(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}