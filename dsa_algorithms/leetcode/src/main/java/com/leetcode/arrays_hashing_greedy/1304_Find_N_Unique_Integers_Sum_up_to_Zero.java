package com.leetcode.arrays_hashing_greedy;

class Solution1304 {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i = 1, j = 0; i <= n / 2; ++i) {
            ans[j++] = i;
            ans[j++] = -i;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1304 _tcSol = new Solution1304();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5");
        try {
            int n = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumZero(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-7,-1,1,3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3");
        try {
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumZero(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,0,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumZero(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();
    }
}