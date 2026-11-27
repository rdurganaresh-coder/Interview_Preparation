package com.leetcode.arrays_hashing_greedy;

class Solution3133 {
    public long minEnd(int n, int x) {
        --n;
        long ans = x;
        for (int i = 0; i < 31; ++i) {
            if ((x >> i & 1) == 0) {
                ans |= (n & 1) << i;
                n >>= 1;
            }
        }
        ans |= (long) n << 31;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3133 _tcSol = new Solution3133();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, x = 4");
        try {
            int n = 3;
            int x = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minEnd(n, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, x = 7");
        try {
            int n = 2;
            int x = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.minEnd(n, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}