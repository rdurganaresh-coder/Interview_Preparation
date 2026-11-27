package com.leetcode.arrays_hashing_greedy;

class Solution1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1846 _tcSol = new Solution1846();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [2,2,1,2,1]");
        try {
            int[] arr = new int[]{2, 2, 1, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumElementAfterDecrementingAndRearranging(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [100,1,1000]");
        try {
            int[] arr = new int[]{100, 1, 1000};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumElementAfterDecrementingAndRearranging(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [1,2,3,4,5]");
        try {
            int[] arr = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumElementAfterDecrementingAndRearranging(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}