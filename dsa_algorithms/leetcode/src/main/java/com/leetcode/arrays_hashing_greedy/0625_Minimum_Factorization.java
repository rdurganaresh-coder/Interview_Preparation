package com.leetcode.arrays_hashing_greedy;

class Solution0625 {
    public int smallestFactorization(int num) {
        if (num < 2) {
            return num;
        }
        long ans = 0, mul = 1;
        for (int i = 9; i >= 2; --i) {
            if (num % i == 0) {
                while (num % i == 0) {
                    num /= i;
                    ans = mul * i + ans;
                    mul *= 10;
                }
            }
        }
        return num < 2 && ans <= Integer.MAX_VALUE ? (int) ans : 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0625 _tcSol = new Solution0625();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 48");
        try {
            int num = 48;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestFactorization(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "68");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 15");
        try {
            int num = 15;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestFactorization(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "35");
        System.out.println();
    }
}