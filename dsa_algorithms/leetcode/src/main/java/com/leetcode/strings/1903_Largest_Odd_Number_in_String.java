package com.leetcode.strings;

class Solution1903 {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; --i) {
            int c = num.charAt(i) - '0';
            if ((c & 1) == 1) {
                return num.substring(0, i + 1);
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
        Solution1903 _tcSol = new Solution1903();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"52\"");
        try {
            String num = "52";
            System.out.println("  Output  : " + _tcShow(_tcSol.largestOddNumber(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"5\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"4206\"");
        try {
            String num = "4206";
            System.out.println("  Output  : " + _tcShow(_tcSol.largestOddNumber(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = \"35427\"");
        try {
            String num = "35427";
            System.out.println("  Output  : " + _tcShow(_tcSol.largestOddNumber(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"35427\"");
        System.out.println();
    }
}