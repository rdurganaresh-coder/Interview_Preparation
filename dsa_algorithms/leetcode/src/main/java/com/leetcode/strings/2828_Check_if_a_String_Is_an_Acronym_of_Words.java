package com.leetcode.strings;

class Solution2828 {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder t = new StringBuilder();
        for (var w : words) {
            t.append(w.charAt(0));
        }
        return t.toString().equals(s);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution2828 _tcSol = new Solution2828();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"alice\",\"bob\",\"charlie\"], s = \"abc\"");
        try {
            List<String> words = _tcL("alice", "bob", "charlie");
            String s = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.isAcronym(words, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"an\",\"apple\"], s = \"a\"");
        try {
            List<String> words = _tcL("an", "apple");
            String s = "a";
            System.out.println("  Output  : " + _tcShow(_tcSol.isAcronym(words, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"never\",\"gonna\",\"give\",\"up\",\"on\",\"you\"], s = \"ngguoy\"");
        try {
            List<String> words = _tcL("never", "gonna", "give", "up", "on", "you");
            String s = "ngguoy";
            System.out.println("  Output  : " + _tcShow(_tcSol.isAcronym(words, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}