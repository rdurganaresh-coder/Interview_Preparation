package com.leetcode.sliding_window_two_pointers;

class Solution2062 {
    public int countVowelSubstrings(String word) {
        int n = word.length();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            Set<Character> t = new HashSet<>();
            for (int j = i; j < n; ++j) {
                char c = word.charAt(j);
                if (!isVowel(c)) {
                    break;
                }
                t.add(c);
                if (t.size() == 5) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2062 _tcSol = new Solution2062();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"aeiouu\"");
        try {
            String word = "aeiouu";
            System.out.println("  Output  : " + _tcShow(_tcSol.countVowelSubstrings(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"unicornarihan\"");
        try {
            String word = "unicornarihan";
            System.out.println("  Output  : " + _tcShow(_tcSol.countVowelSubstrings(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"cuaieuouac\"");
        try {
            String word = "cuaieuouac";
            System.out.println("  Output  : " + _tcShow(_tcSol.countVowelSubstrings(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}