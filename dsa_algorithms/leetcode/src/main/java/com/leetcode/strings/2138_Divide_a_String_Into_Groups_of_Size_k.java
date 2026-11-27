package com.leetcode.strings;

class Solution2138 {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] ans = new String[(n + k - 1) / k];
        if (n % k != 0) {
            s += String.valueOf(fill).repeat(k - n % k);
        }
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = s.substring(i * k, (i + 1) * k);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2138 _tcSol = new Solution2138();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcdefghi\", k = 3, fill = \"x\"");
        try {
            String s = "abcdefghi";
            int k = 3;
            char fill = 'x';
            System.out.println("  Output  : " + _tcShow(_tcSol.divideString(s, k, fill)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"abc\",\"def\",\"ghi\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcdefghij\", k = 3, fill = \"x\"");
        try {
            String s = "abcdefghij";
            int k = 3;
            char fill = 'x';
            System.out.println("  Output  : " + _tcShow(_tcSol.divideString(s, k, fill)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"abc\",\"def\",\"ghi\",\"jxx\"]");
        System.out.println();
    }
}