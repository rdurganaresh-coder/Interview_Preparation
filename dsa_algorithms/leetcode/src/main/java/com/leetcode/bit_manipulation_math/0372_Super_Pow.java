package com.leetcode.bit_manipulation_math;

class Solution0372 {
    private final int mod = 1337;

    public int superPow(int a, int[] b) {
        long ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = ans * qpow(a, b[i]) % mod;
            a = (int) qpow(a, 10);
        }
        return (int) ans;
    }

    private long qpow(long a, int n) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0372 _tcSol = new Solution0372();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = 2, b = [3]");
        try {
            int a = 2;
            int[] b = new int[]{3};
            System.out.println("  Output  : " + _tcShow(_tcSol.superPow(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = 2, b = [1,0]");
        try {
            int a = 2;
            int[] b = new int[]{1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.superPow(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1024");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "a = 1, b = [4,3,3,8,5,2]");
        try {
            int a = 1;
            int[] b = new int[]{4, 3, 3, 8, 5, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.superPow(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}