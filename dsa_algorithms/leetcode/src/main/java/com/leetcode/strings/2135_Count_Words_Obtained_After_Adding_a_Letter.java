package com.leetcode.strings;

class Solution2135 {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> s = new HashSet<>();
        for (var w : startWords) {
            int x = 0;
            for (var c : w.toCharArray()) {
                x |= 1 << (c - 'a');
            }
            s.add(x);
        }
        int ans = 0;
        for (var w : targetWords) {
            int x = 0;
            for (var c : w.toCharArray()) {
                x |= 1 << (c - 'a');
            }
            for (var c : w.toCharArray()) {
                if (s.contains(x ^ (1 << (c - 'a')))) {
                    ++ans;
                    break;
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

    public static void main(String[] args) {
        Solution2135 _tcSol = new Solution2135();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "startWords = [\"ant\",\"act\",\"tack\"], targetWords = [\"tack\",\"act\",\"acti\"]");
        try {
            String[] startWords = new String[]{"ant", "act", "tack"};
            String[] targetWords = new String[]{"tack", "act", "acti"};
            System.out.println("  Output  : " + _tcShow(_tcSol.wordCount(startWords, targetWords)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "startWords = [\"ab\",\"a\"], targetWords = [\"abc\",\"abcd\"]");
        try {
            String[] startWords = new String[]{"ab", "a"};
            String[] targetWords = new String[]{"abc", "abcd"};
            System.out.println("  Output  : " + _tcShow(_tcSol.wordCount(startWords, targetWords)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}