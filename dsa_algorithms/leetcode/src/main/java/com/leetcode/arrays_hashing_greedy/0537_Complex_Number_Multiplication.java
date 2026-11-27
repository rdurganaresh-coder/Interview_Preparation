package com.leetcode.arrays_hashing_greedy;

class Solution0537 {
    public String complexNumberMultiply(String num1, String num2) {
        int[] x = parse(num1);
        int[] y = parse(num2);
        int a1 = x[0], b1 = x[1], a2 = y[0], b2 = y[1];
        return (a1 * a2 - b1 * b2) + "+" + (a1 * b2 + a2 * b1) + "i";
    }

    private int[] parse(String s) {
        var cs = s.substring(0, s.length() - 1).split("\\+");
        return new int[] {Integer.parseInt(cs[0]), Integer.parseInt(cs[1])};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0537 _tcSol = new Solution0537();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num1 = \"1+1i\", num2 = \"1+1i\"");
        try {
            String num1 = "1+1i";
            String num2 = "1+1i";
            System.out.println("  Output  : " + _tcShow(_tcSol.complexNumberMultiply(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0+2i\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num1 = \"1+-1i\", num2 = \"1+-1i\"");
        try {
            String num1 = "1+-1i";
            String num2 = "1+-1i";
            System.out.println("  Output  : " + _tcShow(_tcSol.complexNumberMultiply(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0+-2i\"");
        System.out.println();
    }
}