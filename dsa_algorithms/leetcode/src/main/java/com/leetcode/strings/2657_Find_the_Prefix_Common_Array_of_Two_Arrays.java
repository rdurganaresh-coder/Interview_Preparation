package com.leetcode.strings;

class Solution2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        int[] cnt1 = new int[n + 1];
        int[] cnt2 = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            ++cnt1[A[i]];
            ++cnt2[B[i]];
            for (int j = 1; j <= n; ++j) {
                ans[i] += Math.min(cnt1[j], cnt2[j]);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2657 _tcSol = new Solution2657();
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