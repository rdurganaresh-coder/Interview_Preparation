package com.leetcode.strings;

class Solution0415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        for (int c = 0; i >= 0 || j >= 0 || c > 0; --i, --j) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            c += a + b;
            ans.append(c % 10);
            c /= 10;
        }
        return ans.reverse().toString();
    }

    public String subStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        boolean neg = m < n || (m == n && num1.compareTo(num2) < 0);
        if (neg) {
            String t = num1;
            num1 = num2;
            num2 = t;
        }
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        for (int c = 0; i >= 0; --i, --j) {
            c = (num1.charAt(i) - '0') - c - (j < 0 ? 0 : num2.charAt(j) - '0');
            ans.append((c + 10) % 10);
            c = c < 0 ? 1 : 0;
        }
        while (ans.length() > 1 && ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1);
        }
        if (neg) {
            ans.append('-');
        }
        return ans.reverse().toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0415 _tcSol = new Solution0415();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num1 = \"11\", num2 = \"123\"");
        try {
            String num1 = "11";
            String num2 = "123";
            System.out.println("  Output  : " + _tcShow(_tcSol.addStrings(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"134\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num1 = \"456\", num2 = \"77\"");
        try {
            String num1 = "456";
            String num2 = "77";
            System.out.println("  Output  : " + _tcShow(_tcSol.addStrings(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"533\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num1 = \"0\", num2 = \"0\"");
        try {
            String num1 = "0";
            String num2 = "0";
            System.out.println("  Output  : " + _tcShow(_tcSol.addStrings(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0\"");
        System.out.println();
    }
}