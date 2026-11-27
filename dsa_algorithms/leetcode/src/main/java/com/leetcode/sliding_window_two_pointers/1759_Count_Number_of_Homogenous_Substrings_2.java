package com.leetcode.sliding_window_two_pointers;

class Solution1759_2 {
    private static final int MOD = (int) 1e9 + 7;

    public int countHomogenous(String s) {
        int n = s.length();
        int ans = 1, cnt = 1;
        for (int i = 1; i < n; ++i) {
            cnt = s.charAt(i) == s.charAt(i - 1) ? cnt + 1 : 1;
            ans = (ans + cnt) % MOD;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1759_2 _tcSol = new Solution1759_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abbcccaa\"");
        try {
            String s = "abbcccaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.countHomogenous(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"xy\"");
        try {
            String s = "xy";
            System.out.println("  Output  : " + _tcShow(_tcSol.countHomogenous(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"zzzzz\"");
        try {
            String s = "zzzzz";
            System.out.println("  Output  : " + _tcShow(_tcSol.countHomogenous(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}