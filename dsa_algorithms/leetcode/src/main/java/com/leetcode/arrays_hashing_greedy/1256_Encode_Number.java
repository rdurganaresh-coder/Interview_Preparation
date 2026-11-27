package com.leetcode.arrays_hashing_greedy;

class Solution1256 {
    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1256 _tcSol = new Solution1256();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 23");
        try {
            int num = 23;
            System.out.println("  Output  : " + _tcShow(_tcSol.encode(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1000\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 107");
        try {
            int num = 107;
            System.out.println("  Output  : " + _tcShow(_tcSol.encode(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"101100\"");
        System.out.println();
    }
}