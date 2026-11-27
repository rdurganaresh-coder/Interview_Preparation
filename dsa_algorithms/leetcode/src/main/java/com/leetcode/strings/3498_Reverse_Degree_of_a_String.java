package com.leetcode.strings;

class Solution3498 {
    public int reverseDegree(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            int x = 26 - (s.charAt(i - 1) - 'a');
            ans += i * x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3498 _tcSol = new Solution3498();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abc\"");
        try {
            String s = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseDegree(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "148");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"zaza\"");
        try {
            String s = "zaza";
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseDegree(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "160");
        System.out.println();
    }
}