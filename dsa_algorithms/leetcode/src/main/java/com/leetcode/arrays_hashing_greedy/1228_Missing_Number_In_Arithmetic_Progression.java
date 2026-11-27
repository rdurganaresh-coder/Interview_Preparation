package com.leetcode.arrays_hashing_greedy;

class Solution1228 {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int x = (arr[0] + arr[n - 1]) * (n + 1) / 2;
        int y = Arrays.stream(arr).sum();
        return x - y;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1228 _tcSol = new Solution1228();
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