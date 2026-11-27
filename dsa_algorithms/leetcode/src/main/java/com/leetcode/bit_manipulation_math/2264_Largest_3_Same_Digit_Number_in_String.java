package com.leetcode.bit_manipulation_math;

class Solution2264 {
    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            String s = String.valueOf(i).repeat(3);
            if (num.contains(s)) {
                return s;
            }
        }
        return "";
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2264 _tcSol = new Solution2264();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"6777133339\"");
        try {
            String num = "6777133339";
            System.out.println("  Output  : " + _tcShow(_tcSol.largestGoodInteger(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"777\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"2300019\"");
        try {
            String num = "2300019";
            System.out.println("  Output  : " + _tcShow(_tcSol.largestGoodInteger(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"000\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = \"42352338\"");
        try {
            String num = "42352338";
            System.out.println("  Output  : " + _tcShow(_tcSol.largestGoodInteger(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}