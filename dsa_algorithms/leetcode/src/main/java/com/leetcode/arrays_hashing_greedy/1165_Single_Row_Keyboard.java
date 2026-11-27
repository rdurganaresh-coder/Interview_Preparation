package com.leetcode.arrays_hashing_greedy;

class Solution1165 {
    public int calculateTime(String keyboard, String word) {
        int[] pos = new int[26];
        for (int i = 0; i < 26; ++i) {
            pos[keyboard.charAt(i) - 'a'] = i;
        }
        int ans = 0, i = 0;
        for (int k = 0; k < word.length(); ++k) {
            int j = pos[word.charAt(k) - 'a'];
            ans += Math.abs(i - j);
            i = j;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1165 _tcSol = new Solution1165();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "keyboard = \"abcdefghijklmnopqrstuvwxyz\", word = \"cba\"");
        try {
            String keyboard = "abcdefghijklmnopqrstuvwxyz";
            String word = "cba";
            System.out.println("  Output  : " + _tcShow(_tcSol.calculateTime(keyboard, word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "keyboard = \"pqrstuvwxyzabcdefghijklmno\", word = \"leetcode\"");
        try {
            String keyboard = "pqrstuvwxyzabcdefghijklmno";
            String word = "leetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.calculateTime(keyboard, word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "73");
        System.out.println();
    }
}