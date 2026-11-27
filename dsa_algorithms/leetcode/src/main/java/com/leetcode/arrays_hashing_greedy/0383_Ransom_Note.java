package com.leetcode.arrays_hashing_greedy;

class Solution0383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); ++i) {
            ++cnt[magazine.charAt(i) - 'a'];
        }
        for (int i = 0; i < ransomNote.length(); ++i) {
            if (--cnt[ransomNote.charAt(i) - 'a'] < 0) {
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
        Solution0383 _tcSol = new Solution0383();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "ransomNote = \"a\", magazine = \"b\"");
        try {
            String ransomNote = "a";
            String magazine = "b";
            System.out.println("  Output  : " + _tcShow(_tcSol.canConstruct(ransomNote, magazine)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "ransomNote = \"aa\", magazine = \"ab\"");
        try {
            String ransomNote = "aa";
            String magazine = "ab";
            System.out.println("  Output  : " + _tcShow(_tcSol.canConstruct(ransomNote, magazine)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "ransomNote = \"aa\", magazine = \"aab\"");
        try {
            String ransomNote = "aa";
            String magazine = "aab";
            System.out.println("  Output  : " + _tcShow(_tcSol.canConstruct(ransomNote, magazine)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}