package com.leetcode.arrays_hashing_greedy;

class Solution0476 {
    public int findComplement(int num) {
        return num ^ ((1 << (32 - Integer.numberOfLeadingZeros(num))) - 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0476 _tcSol = new Solution0476();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 5");
        try {
            int num = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.findComplement(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 1");
        try {
            int num = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findComplement(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}