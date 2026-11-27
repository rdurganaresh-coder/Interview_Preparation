package com.leetcode.bit_manipulation_math;

class Solution2939 {
    public int maximumXorProduct(long a, long b, int n) {
        final int mod = (int) 1e9 + 7;
        long ax = (a >> n) << n;
        long bx = (b >> n) << n;
        for (int i = n - 1; i >= 0; --i) {
            long x = a >> i & 1;
            long y = b >> i & 1;
            if (x == y) {
                ax |= 1L << i;
                bx |= 1L << i;
            } else if (ax < bx) {
                ax |= 1L << i;
            } else {
                bx |= 1L << i;
            }
        }
        ax %= mod;
        bx %= mod;
        return (int) (ax * bx % mod);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2939 _tcSol = new Solution2939();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = 12, b = 5, n = 4");
        try {
            long a = 12L;
            long b = 5L;
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumXorProduct(a, b, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "98");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = 6, b = 7 , n = 5");
        try {
            long a = 6L;
            long b = 7L;
            int n = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumXorProduct(a, b, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "930");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "a = 1, b = 6, n = 3");
        try {
            long a = 1L;
            long b = 6L;
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumXorProduct(a, b, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}