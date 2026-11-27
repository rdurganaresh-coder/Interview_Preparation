package com.leetcode.arrays_hashing_greedy;

class Solution2543 {
    public boolean isReachable(int targetX, int targetY) {
        int x = gcd(targetX, targetY);
        return (x & (x - 1)) == 0;
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
        Solution2543 _tcSol = new Solution2543();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "targetX = 6, targetY = 9");
        try {
            int targetX = 6;
            int targetY = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.isReachable(targetX, targetY)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "targetX = 4, targetY = 7");
        try {
            int targetX = 4;
            int targetY = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.isReachable(targetX, targetY)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}