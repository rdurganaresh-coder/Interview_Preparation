package com.leetcode.sliding_window_two_pointers;

class Solution1234 {
    public int balancedString(String s) {
        int[] cnt = new int[4];
        String t = "QWER";
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            cnt[t.indexOf(s.charAt(i))]++;
        }
        int m = n / 4;
        if (cnt[0] == m && cnt[1] == m && cnt[2] == m && cnt[3] == m) {
            return 0;
        }
        int ans = n;
        for (int i = 0, j = 0; i < n; ++i) {
            cnt[t.indexOf(s.charAt(i))]--;
            while (j <= i && cnt[0] <= m && cnt[1] <= m && cnt[2] <= m && cnt[3] <= m) {
                ans = Math.min(ans, i - j + 1);
                cnt[t.indexOf(s.charAt(j++))]++;
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
        Solution1234 _tcSol = new Solution1234();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"QWER\"");
        try {
            String s = "QWER";
            System.out.println("  Output  : " + _tcShow(_tcSol.balancedString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"QQWE\"");
        try {
            String s = "QQWE";
            System.out.println("  Output  : " + _tcShow(_tcSol.balancedString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"QQQW\"");
        try {
            String s = "QQQW";
            System.out.println("  Output  : " + _tcShow(_tcSol.balancedString(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}