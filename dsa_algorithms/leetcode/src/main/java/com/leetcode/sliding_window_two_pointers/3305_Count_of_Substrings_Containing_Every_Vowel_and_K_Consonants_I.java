package com.leetcode.sliding_window_two_pointers;

class Solution3305 {
    public int countOfSubstrings(String word, int k) {
        return f(word, k) - f(word, k + 1);
    }

    private int f(String word, int k) {
        int ans = 0;
        int l = 0, x = 0;
        Map<Character, Integer> cnt = new HashMap<>(5);
        for (char c : word.toCharArray()) {
            if (vowel(c)) {
                cnt.merge(c, 1, Integer::sum);
            } else {
                ++x;
            }
            while (x >= k && cnt.size() == 5) {
                char d = word.charAt(l++);
                if (vowel(d)) {
                    if (cnt.merge(d, -1, Integer::sum) == 0) {
                        cnt.remove(d);
                    }
                } else {
                    --x;
                }
            }
            ans += l;
        }
        return ans;
    }

    private boolean vowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3305 _tcSol = new Solution3305();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"aeioqq\", k = 1");
        try {
            String word = "aeioqq";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfSubstrings(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"aeiou\", k = 0");
        try {
            String word = "aeiou";
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfSubstrings(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "word = \"ieaouqqieaouqq\", k = 1");
        try {
            String word = "ieaouqqieaouqq";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfSubstrings(word, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
