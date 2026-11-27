package com.leetcode.bit_manipulation_math;

class Solution1796 {
    public int secondHighest(String s) {
        int a = -1, b = -1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int v = c - '0';
                if (v > a) {
                    b = a;
                    a = v;
                } else if (v > b && v < a) {
                    b = v;
                }
            }
        }
        return b;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1796 _tcSol = new Solution1796();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"dfa12321afd\"");
        try {
            String s = "dfa12321afd";
            System.out.println("  Output  : " + _tcShow(_tcSol.secondHighest(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abc1111\"");
        try {
            String s = "abc1111";
            System.out.println("  Output  : " + _tcShow(_tcSol.secondHighest(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}