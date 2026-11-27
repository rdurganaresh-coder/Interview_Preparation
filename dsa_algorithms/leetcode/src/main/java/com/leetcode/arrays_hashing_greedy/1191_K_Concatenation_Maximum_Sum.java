package com.leetcode.arrays_hashing_greedy;

class Solution1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long s = 0, mxPre = 0, miPre = 0, mxSub = 0;
        for (int x : arr) {
            s += x;
            mxPre = Math.max(mxPre, s);
            miPre = Math.min(miPre, s);
            mxSub = Math.max(mxSub, s - miPre);
        }
        long ans = mxSub;
        final int mod = (int) 1e9 + 7;
        if (k == 1) {
            return (int) (ans % mod);
        }
        long mxSuf = s - miPre;
        ans = Math.max(ans, mxPre + mxSuf);
        if (s > 0) {
            ans = Math.max(ans, (k - 2) * s + mxPre + mxSuf);
        }
        return (int) (ans % mod);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1191 _tcSol = new Solution1191();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1, 2], k = 3");
        try {
            int[] arr = new int[]{1, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.kConcatenationMaxSum(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1, -2, 1], k = 5");
        try {
            int[] arr = new int[]{1, -2, 1};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.kConcatenationMaxSum(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [-1, -2], k = 7");
        try {
            int[] arr = new int[]{-1, -2};
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.kConcatenationMaxSum(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}