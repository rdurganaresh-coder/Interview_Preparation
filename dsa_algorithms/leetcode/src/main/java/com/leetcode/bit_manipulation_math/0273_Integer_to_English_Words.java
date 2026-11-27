package com.leetcode.bit_manipulation_math;

class Solution0273 {
    private String[] lt20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
        "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens
        = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] thousands = {"Billion", "Million", "Thousand", ""};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1000000000, j = 0; i > 0; i /= 1000, ++j) {
            if (num / i == 0) {
                continue;
            }
            sb.append(transfer(num / i)).append(thousands[j]).append(' ');
            num %= i;
        }
        return sb.toString().trim();
    }

    private String transfer(int num) {
        if (num == 0) {
            return "";
        }
        if (num < 20) {
            return lt20[num] + " ";
        }
        if (num < 100) {
            return tens[num / 10] + " " + transfer(num % 10);
        }
        return lt20[num / 100] + " Hundred " + transfer(num % 100);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0273 _tcSol = new Solution0273();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 123");
        try {
            int num = 123;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberToWords(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"One Hundred Twenty Three\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 12345");
        try {
            int num = 12345;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberToWords(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Twelve Thousand Three Hundred Forty Five\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = 1234567");
        try {
            int num = 1234567;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberToWords(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven\"");
        System.out.println();
    }
}
