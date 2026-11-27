package com.leetcode.strings;

class Solution2490 {
    public boolean isCircularSentence(String sentence) {
        var ss = sentence.split(" ");
        int n = ss.length;
        for (int i = 0; i < n; ++i) {
            if (ss[i].charAt(ss[i].length() - 1) != ss[(i + 1) % n].charAt(0)) {
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
        Solution2490 _tcSol = new Solution2490();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sentence = \"leetcode exercises sound delightful\"");
        try {
            String sentence = "leetcode exercises sound delightful";
            System.out.println("  Output  : " + _tcShow(_tcSol.isCircularSentence(sentence)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sentence = \"eetcode\"");
        try {
            String sentence = "eetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.isCircularSentence(sentence)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "sentence = \"Leetcode is cool\"");
        try {
            String sentence = "Leetcode is cool";
            System.out.println("  Output  : " + _tcShow(_tcSol.isCircularSentence(sentence)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}