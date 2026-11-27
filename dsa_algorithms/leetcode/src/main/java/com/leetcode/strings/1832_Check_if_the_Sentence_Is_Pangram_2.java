package com.leetcode.strings;

class Solution1832_2 {
    public boolean checkIfPangram(String sentence) {
        int mask = 0;
        for (int i = 0; i < sentence.length(); ++i) {
            mask |= 1 << (sentence.charAt(i) - 'a');
        }
        return mask == (1 << 26) - 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1832_2 _tcSol = new Solution1832_2();
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