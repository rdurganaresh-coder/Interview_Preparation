package com.leetcode.strings;

class Solution3014 {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0, k = 1;
        for (int i = 0; i < n / 8; ++i) {
            ans += k * 8;
            ++k;
        }
        ans += k * (n % 8);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3014 _tcSol = new Solution3014();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"abcde\"");
        try {
            String word = "abcde";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPushes(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"xycdefghij\"");
        try {
            String word = "xycdefghij";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumPushes(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}