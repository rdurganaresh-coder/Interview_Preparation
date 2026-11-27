package com.leetcode.bit_manipulation_math;

class Solution0067 {
    public String addBinary(String a, String b) {
        var sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        for (int carry = 0; i >= 0 || j >= 0 || carry > 0; --i, --j) {
            carry += (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0);
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0067 _tcSol = new Solution0067();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = \"11\", b = \"1\"");
        try {
            String a = "11";
            String b = "1";
            System.out.println("  Output  : " + _tcShow(_tcSol.addBinary(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"100\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = \"1010\", b = \"1011\"");
        try {
            String a = "1010";
            String b = "1011";
            System.out.println("  Output  : " + _tcShow(_tcSol.addBinary(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"10101\"");
        System.out.println();
    }
}