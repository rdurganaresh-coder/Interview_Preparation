package com.leetcode.arrays_hashing_greedy;

class Solution2427_2 {
    public int commonFactors(int a, int b) {
        int g = gcd(a, b);
        int ans = 0;
        for (int x = 1; x * x <= g; ++x) {
            if (g % x == 0) {
                ++ans;
                if (x * x < g) {
                    ++ans;
                }
            }
        }
        return ans;
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
        Solution2427_2 _tcSol = new Solution2427_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = 12, b = 6");
        try {
            int a = 12;
            int b = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.commonFactors(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = 25, b = 30");
        try {
            int a = 25;
            int b = 30;
            System.out.println("  Output  : " + _tcShow(_tcSol.commonFactors(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}