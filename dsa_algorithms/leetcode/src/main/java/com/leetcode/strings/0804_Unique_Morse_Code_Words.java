package com.leetcode.strings;

class Solution0804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[] {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
            "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> s = new HashSet<>();
        for (String word : words) {
            StringBuilder t = new StringBuilder();
            for (char c : word.toCharArray()) {
                t.append(codes[c - 'a']);
            }
            s.add(t.toString());
        }
        return s.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0804 _tcSol = new Solution0804();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"gin\",\"zen\",\"gig\",\"msg\"]");
        try {
            String[] words = new String[]{"gin", "zen", "gig", "msg"};
            System.out.println("  Output  : " + _tcShow(_tcSol.uniqueMorseRepresentations(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"a\"]");
        try {
            String[] words = new String[]{"a"};
            System.out.println("  Output  : " + _tcShow(_tcSol.uniqueMorseRepresentations(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}