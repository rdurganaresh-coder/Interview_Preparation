package com.leetcode.strings;

class Solution1554 {
    public boolean differByOne(String[] dict) {
        Set<String> s = new HashSet<>();
        for (String word : dict) {
            for (int i = 0; i < word.length(); ++i) {
                String t = word.substring(0, i) + "*" + word.substring(i + 1);
                if (s.contains(t)) {
                    return true;
                }
                s.add(t);
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1554 _tcSol = new Solution1554();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "dict = [\"abcd\",\"acbd\", \"aacd\"]");
        try {
            String[] dict = new String[]{"abcd", "acbd", "aacd"};
            System.out.println("  Output  : " + _tcShow(_tcSol.differByOne(dict)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "dict = [\"ab\",\"cd\",\"yz\"]");
        try {
            String[] dict = new String[]{"ab", "cd", "yz"};
            System.out.println("  Output  : " + _tcShow(_tcSol.differByOne(dict)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "dict = [\"abcd\",\"cccc\",\"abyd\",\"abab\"]");
        try {
            String[] dict = new String[]{"abcd", "cccc", "abyd", "abab"};
            System.out.println("  Output  : " + _tcShow(_tcSol.differByOne(dict)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}