package com.leetcode.bit_manipulation_math;

class Solution2533 {
    public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {
        final int mod = (int) 1e9 + 7;
        int[] f = new int[maxLength + 1];
        f[0] = 1;
        for (int i = 1; i <= maxLength; ++i) {
            if (i - oneGroup >= 0) {
                f[i] = (f[i] + f[i - oneGroup]) % mod;
            }
            if (i - zeroGroup >= 0) {
                f[i] = (f[i] + f[i - zeroGroup]) % mod;
            }
        }
        int ans = 0;
        for (int i = minLength; i <= maxLength; ++i) {
            ans = (ans + f[i]) % mod;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2533 _tcSol = new Solution2533();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "minLength = 2, maxLength = 3, oneGroup = 1, zeroGroup = 2");
        try {
            int minLength = 2;
            int maxLength = 3;
            int oneGroup = 1;
            int zeroGroup = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.goodBinaryStrings(minLength, maxLength, oneGroup, zeroGroup)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "minLength = 4, maxLength = 4, oneGroup = 4, zeroGroup = 3");
        try {
            int minLength = 4;
            int maxLength = 4;
            int oneGroup = 4;
            int zeroGroup = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.goodBinaryStrings(minLength, maxLength, oneGroup, zeroGroup)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}