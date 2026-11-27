package com.leetcode.strings;

class Solution2746 {
    private Integer[][][] f;
    private String[] words;
    private int n;

    public int minimizeConcatenatedLength(String[] words) {
        n = words.length;
        this.words = words;
        f = new Integer[n][26][26];
        return words[0].length()
            + dfs(1, words[0].charAt(0) - 'a', words[0].charAt(words[0].length() - 1) - 'a');
    }

    private int dfs(int i, int a, int b) {
        if (i >= n) {
            return 0;
        }
        if (f[i][a][b] != null) {
            return f[i][a][b];
        }
        String s = words[i];
        int m = s.length();
        int x = dfs(i + 1, a, s.charAt(m - 1) - 'a') - (s.charAt(0) - 'a' == b ? 1 : 0);
        int y = dfs(i + 1, s.charAt(0) - 'a', b) - (s.charAt(m - 1) - 'a' == a ? 1 : 0);
        return f[i][a][b] = m + Math.min(x, y);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2746 _tcSol = new Solution2746();
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
