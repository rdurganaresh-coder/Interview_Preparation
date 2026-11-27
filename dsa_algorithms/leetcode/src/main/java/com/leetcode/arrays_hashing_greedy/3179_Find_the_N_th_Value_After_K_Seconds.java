package com.leetcode.arrays_hashing_greedy;

class Solution3179 {
    public int valueAfterKSeconds(int n, int k) {
        final int mod = (int) 1e9 + 7;
        int[] a = new int[n];
        Arrays.fill(a, 1);
        while (k-- > 0) {
            for (int i = 1; i < n; ++i) {
                a[i] = (a[i] + a[i - 1]) % mod;
            }
        }
        return a[n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3179 _tcSol = new Solution3179();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, k = 5");
        try {
            int n = 4;
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.valueAfterKSeconds(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "56");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, k = 3");
        try {
            int n = 5;
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.valueAfterKSeconds(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "35");
        System.out.println();
    }
}