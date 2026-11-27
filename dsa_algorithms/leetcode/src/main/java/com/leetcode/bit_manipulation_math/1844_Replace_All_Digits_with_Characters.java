package com.leetcode.bit_manipulation_math;

class Solution1844 {
    public String replaceDigits(String s) {
        char[] cs = s.toCharArray();
        for (int i = 1; i < cs.length; i += 2) {
            cs[i] = (char) (cs[i - 1] + (cs[i] - '0'));
        }
        return String.valueOf(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1844 _tcSol = new Solution1844();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"a1c1e1\"");
        try {
            String s = "a1c1e1";
            System.out.println("  Output  : " + _tcShow(_tcSol.replaceDigits(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abcdef\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"a1b2c3d4e\"");
        try {
            String s = "a1b2c3d4e";
            System.out.println("  Output  : " + _tcShow(_tcSol.replaceDigits(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abbdcfdhe\"");
        System.out.println();
    }
}