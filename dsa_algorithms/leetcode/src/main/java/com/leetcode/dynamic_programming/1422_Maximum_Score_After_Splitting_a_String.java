package com.leetcode.dynamic_programming;

class Solution1422 {
    public int maxScore(String s) {
        int l = 0, r = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '1') {
                ++r;
            }
        }
        int ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            l += (s.charAt(i) - '0') ^ 1;
            r -= s.charAt(i) - '0';
            ans = Math.max(ans, l + r);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1422 _tcSol = new Solution1422();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"011101\"");
        try {
            String s = "011101";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"00111\"");
        try {
            String s = "00111";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"1111\"");
        try {
            String s = "1111";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
