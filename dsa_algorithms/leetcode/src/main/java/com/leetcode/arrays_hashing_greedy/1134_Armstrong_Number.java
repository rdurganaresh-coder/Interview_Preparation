package com.leetcode.arrays_hashing_greedy;

class Solution1134 {
    public boolean isArmstrong(int n) {
        int k = (n + "").length();
        int s = 0;
        for (int x = n; x > 0; x /= 10) {
            s += Math.pow(x % 10, k);
        }
        return s == n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1134 _tcSol = new Solution1134();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 153");
        try {
            int n = 153;
            System.out.println("  Output  : " + _tcShow(_tcSol.isArmstrong(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 123");
        try {
            int n = 123;
            System.out.println("  Output  : " + _tcShow(_tcSol.isArmstrong(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}