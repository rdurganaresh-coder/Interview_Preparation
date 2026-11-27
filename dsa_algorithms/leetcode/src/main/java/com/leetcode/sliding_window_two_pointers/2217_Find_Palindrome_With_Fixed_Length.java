package com.leetcode.sliding_window_two_pointers;

class Solution2217 {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] ans = new long[n];
        int l = (intLength + 1) >> 1;
        long start = (long) Math.pow(10, l - 1);
        long end = (long) Math.pow(10, l) - 1;
        for (int i = 0; i < n; ++i) {
            long v = start + queries[i] - 1;
            if (v > end) {
                ans[i] = -1;
                continue;
            }
            String s = "" + v;
            s += new StringBuilder(s).reverse().substring(intLength % 2);
            ans[i] = Long.parseLong(s);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2217 _tcSol = new Solution2217();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "queries = [1,2,3,4,5,90], intLength = 3");
        try {
            int[] queries = new int[]{1, 2, 3, 4, 5, 90};
            int intLength = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthPalindrome(queries, intLength)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[101,111,121,131,141,999]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "queries = [2,4,6], intLength = 4");
        try {
            int[] queries = new int[]{2, 4, 6};
            int intLength = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthPalindrome(queries, intLength)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1111,1331,1551]");
        System.out.println();
    }
}