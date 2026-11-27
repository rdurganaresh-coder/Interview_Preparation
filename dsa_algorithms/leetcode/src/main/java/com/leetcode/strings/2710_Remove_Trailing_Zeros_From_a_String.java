package com.leetcode.strings;

class Solution2710 {
    public String removeTrailingZeros(String num) {
        int i = num.length() - 1;
        while (num.charAt(i) == '0') {
            --i;
        }
        return num.substring(0, i + 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2710 _tcSol = new Solution2710();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"51230100\"");
        try {
            String num = "51230100";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeTrailingZeros(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"512301\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"123\"");
        try {
            String num = "123";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeTrailingZeros(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"123\"");
        System.out.println();
    }
}