package com.leetcode.arrays_hashing_greedy;

class Solution1228_2 {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int d = (arr[n - 1] - arr[0]) / n;
        for (int i = 1; i < n; ++i) {
            if (arr[i] != arr[i - 1] + d) {
                return arr[i - 1] + d;
            }
        }
        return arr[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1228_2 _tcSol = new Solution1228_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [5,7,11,13]");
        try {
            int[] arr = new int[]{5, 7, 11, 13};
            System.out.println("  Output  : " + _tcShow(_tcSol.missingNumber(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [15,13,12]");
        try {
            int[] arr = new int[]{15, 13, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.missingNumber(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();
    }
}