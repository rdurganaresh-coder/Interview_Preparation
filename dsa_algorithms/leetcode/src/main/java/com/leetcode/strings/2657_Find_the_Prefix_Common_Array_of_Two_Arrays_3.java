package com.leetcode.strings;

class Solution2657_3 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        long x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            x |= 1L << A[i];
            y |= 1L << B[i];
            ans[i] = Long.bitCount(x & y);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2657_3 _tcSol = new Solution2657_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "A = [1,3,2,4], B = [3,1,2,4]");
        try {
            int[] A = new int[]{1, 3, 2, 4};
            int[] B = new int[]{3, 1, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findThePrefixCommonArray(A, B)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2,3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "A = [2,3,1], B = [3,1,2]");
        try {
            int[] A = new int[]{2, 3, 1};
            int[] B = new int[]{3, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findThePrefixCommonArray(A, B)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,3]");
        System.out.println();
    }
}