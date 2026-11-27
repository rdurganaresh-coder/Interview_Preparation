package com.leetcode.arrays_hashing_greedy;

class Solution2894 {
    public int differenceOfSums(int n, int m) {
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            ans += i % m == 0 ? -i : i;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2894 _tcSol = new Solution2894();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 10, m = 3");
        try {
            int n = 10;
            int m = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.differenceOfSums(n, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, m = 6");
        try {
            int n = 5;
            int m = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.differenceOfSums(n, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5, m = 1");
        try {
            int n = 5;
            int m = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.differenceOfSums(n, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-15");
        System.out.println();
    }
}