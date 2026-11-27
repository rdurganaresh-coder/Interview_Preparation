package com.leetcode.arrays_hashing_greedy;

class Solution0858 {
    public int mirrorReflection(int p, int q) {
        int g = gcd(p, q);
        p = (p / g) % 2;
        q = (q / g) % 2;
        if (p == 1 && q == 1) {
            return 1;
        }
        return p == 1 ? 0 : 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0858 _tcSol = new Solution0858();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "p = 2, q = 1");
        try {
            int p = 2;
            int q = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.mirrorReflection(p, q)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "p = 3, q = 1");
        try {
            int p = 3;
            int q = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.mirrorReflection(p, q)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}