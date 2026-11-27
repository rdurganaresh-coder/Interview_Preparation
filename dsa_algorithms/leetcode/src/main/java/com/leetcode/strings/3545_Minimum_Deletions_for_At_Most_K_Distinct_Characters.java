package com.leetcode.strings;

class Solution3545 {
    public int minDeletion(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        Arrays.sort(cnt);
        int ans = 0;
        for (int i = 0; i + k < 26; ++i) {
            ans += cnt[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3545 _tcSol = new Solution3545();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abc\", k = 2");
        try {
            String s = "abc";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletion(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aabb\", k = 2");
        try {
            String s = "aabb";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletion(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"yyyzz\", k = 1");
        try {
            String s = "yyyzz";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletion(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}