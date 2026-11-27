package com.leetcode.strings;

class Solution0424 {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int l = 0, mx = 0;
        int n = s.length();
        for (int r = 0; r < n; ++r) {
            mx = Math.max(mx, ++cnt[s.charAt(r) - 'A']);
            if (r - l + 1 - mx > k) {
                --cnt[s.charAt(l++) - 'A'];
            }
        }
        return n - l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0424 _tcSol = new Solution0424();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"ABAB\", k = 2");
        try {
            String s = "ABAB";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.characterReplacement(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"AABABBA\", k = 1");
        try {
            String s = "AABABBA";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.characterReplacement(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}