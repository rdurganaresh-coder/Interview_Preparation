package com.leetcode.dynamic_programming;

class Solution1639_2 {
    public int numWays(String[] words, String target) {
        int m = target.length();
        int n = words[0].length();
        final int mod = (int) 1e9 + 7;
        long[][] f = new long[m + 1][n + 1];
        Arrays.fill(f[0], 1);
        int[][] cnt = new int[n][26];
        for (var w : words) {
            for (int j = 0; j < n; ++j) {
                cnt[j][w.charAt(j) - 'a']++;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                f[i][j] = f[i][j - 1] + f[i - 1][j - 1] * cnt[j - 1][target.charAt(i - 1) - 'a'];
                f[i][j] %= mod;
            }
        }
        return (int) f[m][n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1639_2 _tcSol = new Solution1639_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "words = [\"acca\",\"bbbb\",\"caca\"], target = \"aba\"");
        try {
            String[] words = new String[]{"acca", "bbbb", "caca"};
            String target = "aba";
            System.out.println("  Output  : " + _tcShow(_tcSol.numWays(words, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "words = [\"abba\",\"baab\"], target = \"bab\"");
        try {
            String[] words = new String[]{"abba", "baab"};
            String target = "bab";
            System.out.println("  Output  : " + _tcShow(_tcSol.numWays(words, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}