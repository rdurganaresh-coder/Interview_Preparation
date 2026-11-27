package com.leetcode.dynamic_programming;

class Solution1255 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] cnt = new int[26];
        for (int i = 0; i < letters.length; ++i) {
            cnt[letters[i] - 'a']++;
        }
        int n = words.length;
        int ans = 0;
        for (int i = 0; i < 1 << n; ++i) {
            int[] cur = new int[26];
            for (int j = 0; j < n; ++j) {
                if (((i >> j) & 1) == 1) {
                    for (int k = 0; k < words[j].length(); ++k) {
                        cur[words[j].charAt(k) - 'a']++;
                    }
                }
            }
            boolean ok = true;
            int t = 0;
            for (int j = 0; j < 26; ++j) {
                if (cur[j] > cnt[j]) {
                    ok = false;
                    break;
                }
                t += cur[j] * score[j];
            }
            if (ok && ans < t) {
                ans = t;
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
        Solution1255 _tcSol = new Solution1255();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"dog\",\"cat\",\"dad\",\"good\"], letters = [\"a\",\"a\",\"c\",\"d\",\"d\",\"d\",\"g\",\"o\",\"o\"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]");
        try {
            String[] words = new String[]{"dog", "cat", "dad", "good"};
            char[] letters = new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
            int[] score = new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScoreWords(words, letters, score)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "23");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"xxxz\",\"ax\",\"bx\",\"cx\"], letters = [\"z\",\"a\",\"b\",\"c\",\"x\",\"x\",\"x\"], score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]");
        try {
            String[] words = new String[]{"xxxz", "ax", "bx", "cx"};
            char[] letters = new char[]{'z', 'a', 'b', 'c', 'x', 'x', 'x'};
            int[] score = new int[]{4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScoreWords(words, letters, score)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "27");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"leetcode\"], letters = [\"l\",\"e\",\"t\",\"c\",\"o\",\"d\"], score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0]");
        try {
            String[] words = new String[]{"leetcode"};
            char[] letters = new char[]{'l', 'e', 't', 'c', 'o', 'd'};
            int[] score = new int[]{0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScoreWords(words, letters, score)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}