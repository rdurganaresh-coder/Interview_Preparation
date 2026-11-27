package com.leetcode.arrays_hashing_greedy;

class Solution0504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        return sb.reverse().toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0504 _tcSol = new Solution0504();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 100");
        try {
            int num = 100;
            System.out.println("  Output  : " + _tcShow(_tcSol.convertToBase7(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"202\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = -7");
        try {
            int num = -7;
            System.out.println("  Output  : " + _tcShow(_tcSol.convertToBase7(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"-10\"");
        System.out.println();
    }
}