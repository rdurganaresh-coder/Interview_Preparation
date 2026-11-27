package com.leetcode.bit_manipulation_math;

class Solution0592 {
    public String fractionAddition(String expression) {
        int x = 0, y = 6 * 7 * 8 * 9 * 10;
        if (Character.isDigit(expression.charAt(0))) {
            expression = "+" + expression;
        }
        int i = 0, n = expression.length();
        while (i < n) {
            int sign = expression.charAt(i) == '-' ? -1 : 1;
            ++i;
            int j = i;
            while (j < n && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                ++j;
            }
            String s = expression.substring(i, j);
            String[] t = s.split("/");
            int a = Integer.parseInt(t[0]), b = Integer.parseInt(t[1]);
            x += sign * a * y / b;
            i = j;
        }
        int z = gcd(Math.abs(x), y);
        x /= z;
        y /= z;
        return x + "/" + y;
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
        Solution0592 _tcSol = new Solution0592();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "expression = \"-1/2+1/2\"");
        try {
            String expression = "-1/2+1/2";
            System.out.println("  Output  : " + _tcShow(_tcSol.fractionAddition(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0/1\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "expression = \"-1/2+1/2+1/3\"");
        try {
            String expression = "-1/2+1/2+1/3";
            System.out.println("  Output  : " + _tcShow(_tcSol.fractionAddition(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1/3\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "expression = \"1/3-1/2\"");
        try {
            String expression = "1/3-1/2";
            System.out.println("  Output  : " + _tcShow(_tcSol.fractionAddition(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"-1/6\"");
        System.out.println();
    }
}