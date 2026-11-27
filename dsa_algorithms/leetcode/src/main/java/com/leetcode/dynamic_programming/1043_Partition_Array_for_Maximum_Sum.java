package com.leetcode.dynamic_programming;

class Solution1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int mx = 0;
            for (int j = i; j > Math.max(0, i - k); --j) {
                mx = Math.max(mx, arr[j - 1]);
                f[i] = Math.max(f[i], f[j - 1] + mx * (i - j + 1));
            }
        }
        return f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1043 _tcSol = new Solution1043();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,15,7,9,2,5,10], k = 3");
        try {
            int[] arr = new int[]{1, 15, 7, 9, 2, 5, 10};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumAfterPartitioning(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "84");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4");
        try {
            int[] arr = new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumAfterPartitioning(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "83");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [1], k = 1");
        try {
            int[] arr = new int[]{1};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumAfterPartitioning(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}