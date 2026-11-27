package com.leetcode.strings;

import java.util.regex.Pattern;

class Solution2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (var w : words) {
            for (var s : w.split(Pattern.quote(String.valueOf(separator)))) {
                if (s.length() > 0) {
                    ans.add(s);
                }
            }
        }
        return ans;
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
        Solution2788 _tcSol = new Solution2788();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"one.two.three\",\"four.five\",\"six\"], separator = \".\"");
        try {
            List<String> words = _tcL("one.two.three", "four.five", "six");
            char separator = '.';
            System.out.println("  Output  : " + _tcShow(_tcSol.splitWordsBySeparator(words, separator)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"one\",\"two\",\"three\",\"four\",\"five\",\"six\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"$easy$\",\"$problem$\"], separator = \"$\"");
        try {
            List<String> words = _tcL("$easy$", "$problem$");
            char separator = '$';
            System.out.println("  Output  : " + _tcShow(_tcSol.splitWordsBySeparator(words, separator)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"easy\",\"problem\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"|||\"], separator = \"|\"");
        try {
            List<String> words = _tcL("|||");
            char separator = '|';
            System.out.println("  Output  : " + _tcShow(_tcSol.splitWordsBySeparator(words, separator)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}