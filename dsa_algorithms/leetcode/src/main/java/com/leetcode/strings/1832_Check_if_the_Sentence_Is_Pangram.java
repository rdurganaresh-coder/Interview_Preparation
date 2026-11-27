package com.leetcode.strings;

class Solution1832 {
    public boolean checkIfPangram(String sentence) {
        boolean[] vis = new boolean[26];
        for (int i = 0; i < sentence.length(); ++i) {
            vis[sentence.charAt(i) - 'a'] = true;
        }
        for (boolean v : vis) {
            if (!v) {
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
        Solution1832 _tcSol = new Solution1832();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sentence = \"thequickbrownfoxjumpsoverthelazydog\"");
        try {
            String sentence = "thequickbrownfoxjumpsoverthelazydog";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkIfPangram(sentence)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sentence = \"leetcode\"");
        try {
            String sentence = "leetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkIfPangram(sentence)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}