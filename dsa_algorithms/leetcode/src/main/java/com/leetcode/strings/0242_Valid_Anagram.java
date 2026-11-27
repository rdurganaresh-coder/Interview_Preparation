package com.leetcode.strings;

class Solution0242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
            --cnt[t.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0242 _tcSol = new Solution0242();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"anagram\", t = \"nagaram\"");
        try {
            String s = "anagram";
            String t = "nagaram";
            System.out.println("  Output  : " + _tcShow(_tcSol.isAnagram(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"rat\", t = \"car\"");
        try {
            String s = "rat";
            String t = "car";
            System.out.println("  Output  : " + _tcShow(_tcSol.isAnagram(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}