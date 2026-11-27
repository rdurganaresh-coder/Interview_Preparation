package com.leetcode.strings;

class Solution2904_2 {
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0, j = 0, cnt = 0;
        int n = s.length();
        String ans = "";
        while (j < n) {
            cnt += s.charAt(j) - '0';
            while (cnt > k || (i < j && s.charAt(i) == '0')) {
                cnt -= s.charAt(i) - '0';
                ++i;
            }
            ++j;
            String t = s.substring(i, j);
            if (cnt == k
                && ("".equals(ans) || j - i < ans.length()
                    || (j - i == ans.length() && t.compareTo(ans) < 0))) {
                ans = t;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2904_2 _tcSol = new Solution2904_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"100011001\", k = 3");
        try {
            String s = "100011001";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestBeautifulSubstring(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"11001\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"1011\", k = 2");
        try {
            String s = "1011";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestBeautifulSubstring(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"11\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"000\", k = 1");
        try {
            String s = "000";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestBeautifulSubstring(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}