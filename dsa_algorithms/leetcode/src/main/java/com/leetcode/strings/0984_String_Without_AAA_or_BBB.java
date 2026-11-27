package com.leetcode.strings;

class Solution0984 {
    public String strWithout3a3b(int a, int b) {
        StringBuilder ans = new StringBuilder();
        while (a > 0 && b > 0) {
            if (a > b) {
                ans.append("aab");
                a -= 2;
                b -= 1;
            } else if (a < b) {
                ans.append("bba");
                a -= 1;
                b -= 2;
            } else {
                ans.append("ab");
                --a;
                --b;
            }
        }
        if (a > 0) {
            ans.append("a".repeat(a));
        }
        if (b > 0) {
            ans.append("b".repeat(b));
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0984 _tcSol = new Solution0984();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = 1, b = 2");
        try {
            int a = 1;
            int b = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.strWithout3a3b(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abb\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = 4, b = 1");
        try {
            int a = 4;
            int b = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.strWithout3a3b(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aabaa\"");
        System.out.println();
    }
}