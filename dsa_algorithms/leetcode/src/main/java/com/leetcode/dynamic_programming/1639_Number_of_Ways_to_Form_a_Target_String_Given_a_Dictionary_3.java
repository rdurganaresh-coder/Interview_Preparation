package com.leetcode.dynamic_programming;

class Solution1639_3 {
    public int numWays(String[] words, String target) {
        int m = target.length();
        int n = words[0].length();
        final int mod = (int) 1e9 + 7;
        int[][] cnt = new int[n][26];
        for (var w : words) {
            for (int j = 0; j < n; ++j) {
                cnt[j][w.charAt(j) - 'a']++;
            }
        }
        int[][] f = new int[m + 1][n + 1];
        for (int j = 0; j <= n; ++j) {
            f[m][j] = 1;
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                long ans = f[i][j + 1];
                ans += 1L * f[i + 1][j + 1] * cnt[j][target.charAt(i) - 'a'];
                f[i][j] = (int) (ans % mod);
            }
        }
        return f[0][0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1639_3 _tcSol = new Solution1639_3();
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
