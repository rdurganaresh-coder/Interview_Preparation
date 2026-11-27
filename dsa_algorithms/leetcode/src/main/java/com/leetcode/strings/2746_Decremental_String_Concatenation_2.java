package com.leetcode.strings;

class Solution2746_2 {
    public int minimizeConcatenatedLength(String[] words) {
        int n = words.length;
        int[][][] f = new int[n + 1][26][26];
        for (int i = n - 1; i > 0; --i) {
            String s = words[i];
            int m = s.length();
            int c = s.charAt(0) - 'a';
            int d = s.charAt(m - 1) - 'a';
            for (int a = 0; a < 26; ++a) {
                for (int b = 0; b < 26; ++b) {
                    int x = f[i + 1][a][d] - (c == b ? 1 : 0);
                    int y = f[i + 1][c][b] - (d == a ? 1 : 0);
                    f[i][a][b] = m + Math.min(x, y);
                }
            }
        }
        int a = words[0].charAt(0) - 'a';
        int b = words[0].charAt(words[0].length() - 1) - 'a';
        return words[0].length() + f[1][a][b];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2746_2 _tcSol = new Solution2746_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"aa\",\"ab\",\"bc\"]");
        try {
            String[] words = new String[]{"aa", "ab", "bc"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeConcatenatedLength(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"ab\",\"b\"]");
        try {
            String[] words = new String[]{"ab", "b"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeConcatenatedLength(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "words = [\"aaa\",\"c\",\"aba\"]");
        try {
            String[] words = new String[]{"aaa", "c", "aba"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeConcatenatedLength(words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
