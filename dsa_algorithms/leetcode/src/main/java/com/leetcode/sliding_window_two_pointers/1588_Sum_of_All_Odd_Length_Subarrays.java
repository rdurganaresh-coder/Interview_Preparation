package com.leetcode.sliding_window_two_pointers;

class Solution1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] f = new int[n];
        int[] g = new int[n];
        int ans = f[0] = arr[0];
        for (int i = 1; i < n; ++i) {
            f[i] = g[i - 1] + arr[i] * (i / 2 + 1);
            g[i] = f[i - 1] + arr[i] * ((i + 1) / 2);
            ans += f[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1588 _tcSol = new Solution1588();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,4,2,5,3]");
        try {
            int[] arr = new int[]{1, 4, 2, 5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOddLengthSubarrays(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "58");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,2]");
        try {
            int[] arr = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOddLengthSubarrays(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [10,11,12]");
        try {
            int[] arr = new int[]{10, 11, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOddLengthSubarrays(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "66");
        System.out.println();
    }
}
