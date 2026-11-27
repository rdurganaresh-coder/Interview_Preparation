package com.leetcode.backtracking;

class Solution1734 {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int a = 0, b = 0;
        for (int i = 0; i < n - 1; i += 2) {
            a ^= encoded[i];
        }
        for (int i = 1; i <= n; ++i) {
            b ^= i;
        }
        int[] perm = new int[n];
        perm[n - 1] = a ^ b;
        for (int i = n - 2; i >= 0; --i) {
            perm[i] = encoded[i] ^ perm[i + 1];
        }
        return perm;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1734 _tcSol = new Solution1734();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "encoded = [3,1]");
        try {
            int[] encoded = new int[]{3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.decode(encoded)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "encoded = [6,5,4,6]");
        try {
            int[] encoded = new int[]{6, 5, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.decode(encoded)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,4,1,5,3]");
        System.out.println();
    }
}