package com.leetcode.strings;

class Solution0893 {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> s = new HashSet<>();
        for (String word : words) {
            s.add(convert(word));
        }
        return s.size();
    }

    private String convert(String word) {
        List<Character> a = new ArrayList<>();
        List<Character> b = new ArrayList<>();
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (i % 2 == 0) {
                a.add(ch);
            } else {
                b.add(ch);
            }
        }
        Collections.sort(a);
        Collections.sort(b);
        StringBuilder sb = new StringBuilder();
        for (char c : a) {
            sb.append(c);
        }
        for (char c : b) {
            sb.append(c);
        }
        return sb.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0893 _tcSol = new Solution0893();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"abcd\",\"cdab\",\"cbad\",\"xyzz\",\"zzxy\",\"zzyx\"]");
        try {
            String[] words = new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"};
            System.out.println("  Output  : " + _tcShow(_tcSol.numSpecialEquivGroups(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"abc\",\"acb\",\"bac\",\"bca\",\"cab\",\"cba\"]");
        try {
            String[] words = new String[]{"abc", "acb", "bac", "bca", "cab", "cba"};
            System.out.println("  Output  : " + _tcShow(_tcSol.numSpecialEquivGroups(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}