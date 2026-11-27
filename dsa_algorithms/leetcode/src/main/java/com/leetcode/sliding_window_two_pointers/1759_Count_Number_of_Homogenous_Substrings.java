package com.leetcode.sliding_window_two_pointers;

class Solution1759 {
    private static final int MOD = (int) 1e9 + 7;

    public int countHomogenous(String s) {
        int n = s.length();
        long ans = 0;
        for (int i = 0, j = 0; i < n; i = j) {
            j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                ++j;
            }
            int cnt = j - i;
            ans += (long) (1 + cnt) * cnt / 2;
            ans %= MOD;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1759 _tcSol = new Solution1759();
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