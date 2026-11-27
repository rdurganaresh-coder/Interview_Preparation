package com.leetcode.strings;

class Solution0880 {
    public String decodeAtIndex(String s, int k) {
        long m = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                m *= (s.charAt(i) - '0');
            } else {
                ++m;
            }
        }
        for (int i = s.length() - 1;; --i) {
            k %= m;
            if (k == 0 && !Character.isDigit(s.charAt(i))) {
                return String.valueOf(s.charAt(i));
            }
            if (Character.isDigit(s.charAt(i))) {
                m /= (s.charAt(i) - '0');
            } else {
                --m;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0880 _tcSol = new Solution0880();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leet2code3\", k = 10");
        try {
            String s = "leet2code3";
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.decodeAtIndex(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"o\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"ha22\", k = 5");
        try {
            String s = "ha22";
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.decodeAtIndex(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"h\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"a2345678999999999999999\", k = 1");
        try {
            String s = "a2345678999999999999999";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.decodeAtIndex(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"a\"");
        System.out.println();
    }
}