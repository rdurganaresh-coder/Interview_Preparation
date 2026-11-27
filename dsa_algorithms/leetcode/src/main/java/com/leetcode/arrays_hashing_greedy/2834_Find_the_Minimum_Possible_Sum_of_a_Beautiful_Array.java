package com.leetcode.arrays_hashing_greedy;

class Solution2834 {
    public int minimumPossibleSum(int n, int target) {
        final int mod = (int) 1e9 + 7;
        int m = target / 2;
        if (n <= m) {
            return (int) ((1L + n) * n / 2 % mod);
        }
        long a = (1L + m) * m / 2 % mod;
        long b = ((1L * target + target + n - m - 1) * (n - m) / 2) % mod;
        return (int) ((a + b) % mod);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2834 _tcSol = new Solution2834();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, target = 3");
        try {
            int n = 2;
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPossibleSum(n, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, target = 3");
        try {
            int n = 3;
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPossibleSum(n, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 1, target = 1");
        try {
            int n = 1;
            int target = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPossibleSum(n, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}