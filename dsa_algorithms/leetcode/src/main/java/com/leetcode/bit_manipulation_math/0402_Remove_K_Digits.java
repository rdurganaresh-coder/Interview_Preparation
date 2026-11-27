package com.leetcode.bit_manipulation_math;

class Solution0402 {
    public String removeKdigits(String num, int k) {
        StringBuilder stk = new StringBuilder();
        for (char c : num.toCharArray()) {
            while (k > 0 && stk.length() > 0 && stk.charAt(stk.length() - 1) > c) {
                stk.deleteCharAt(stk.length() - 1);
                --k;
            }
            stk.append(c);
        }
        for (; k > 0; --k) {
            stk.deleteCharAt(stk.length() - 1);
        }
        int i = 0;
        for (; i < stk.length() && stk.charAt(i) == '0'; ++i) {
        }
        String ans = stk.substring(i);
        return "".equals(ans) ? "0" : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0402 _tcSol = new Solution0402();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"1432219\", k = 3");
        try {
            String num = "1432219";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.removeKdigits(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1219\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"10200\", k = 1");
        try {
            String num = "10200";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.removeKdigits(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"200\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = \"10\", k = 2");
        try {
            String num = "10";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.removeKdigits(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0\"");
        System.out.println();
    }
}