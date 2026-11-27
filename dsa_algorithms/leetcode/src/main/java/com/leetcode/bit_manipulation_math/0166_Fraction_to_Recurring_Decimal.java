package com.leetcode.bit_manipulation_math;

class Solution0166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean neg = (numerator > 0) ^ (denominator > 0);
        sb.append(neg ? "-" : "");
        long a = Math.abs((long) numerator), b = Math.abs((long) denominator);
        sb.append(a / b);
        a %= b;
        if (a == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> d = new HashMap<>();
        while (a != 0) {
            d.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
            if (d.containsKey(a)) {
                sb.insert(d.get(a), "(");
                sb.append(")");
                break;
            }
        }
        return sb.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0166 _tcSol = new Solution0166();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numerator = 1, denominator = 2");
        try {
            int numerator = 1;
            int denominator = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.fractionToDecimal(numerator, denominator)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0.5\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numerator = 2, denominator = 1");
        try {
            int numerator = 2;
            int denominator = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.fractionToDecimal(numerator, denominator)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"2\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "numerator = 4, denominator = 333");
        try {
            int numerator = 4;
            int denominator = 333;
            System.out.println("  Output  : " + _tcShow(_tcSol.fractionToDecimal(numerator, denominator)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0.(012)\"");
        System.out.println();
    }
}