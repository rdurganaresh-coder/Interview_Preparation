package com.leetcode.strings;

class Solution1347 {
    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int ans = 0;
        for (char c : t.toCharArray()) {
            if (--cnt[c - 'a'] < 0) {
                ans++;
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
        Solution1347 _tcSol = new Solution1347();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"bab\", t = \"aba\"");
        try {
            String s = "bab";
            String t = "aba";
            System.out.println("  Output  : " + _tcShow(_tcSol.minSteps(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"leetcode\", t = \"practice\"");
        try {
            String s = "leetcode";
            String t = "practice";
            System.out.println("  Output  : " + _tcShow(_tcSol.minSteps(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"anagram\", t = \"mangaar\"");
        try {
            String s = "anagram";
            String t = "mangaar";
            System.out.println("  Output  : " + _tcShow(_tcSol.minSteps(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
