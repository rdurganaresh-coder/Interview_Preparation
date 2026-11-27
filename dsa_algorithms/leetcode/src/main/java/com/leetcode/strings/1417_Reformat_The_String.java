package com.leetcode.strings;

class Solution1417 {
    public String reformat(String s) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                a.append(c);
            } else {
                b.append(c);
            }
        }
        int m = a.length(), n = b.length();
        if (Math.abs(m - n) > 1) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < Math.min(m, n); ++i) {
            if (m > n) {
                ans.append(a.charAt(i));
                ans.append(b.charAt(i));
            } else {
                ans.append(b.charAt(i));
                ans.append(a.charAt(i));
            }
        }
        if (m > n) {
            ans.append(a.charAt(m - 1));
        }
        if (m < n) {
            ans.append(b.charAt(n - 1));
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1417 _tcSol = new Solution1417();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"a0b1c2\"");
        try {
            String s = "a0b1c2";
            System.out.println("  Output  : " + _tcShow(_tcSol.reformat(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0a1b2c\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"leetcode\"");
        try {
            String s = "leetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.reformat(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"1229857369\"");
        try {
            String s = "1229857369";
            System.out.println("  Output  : " + _tcShow(_tcSol.reformat(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}