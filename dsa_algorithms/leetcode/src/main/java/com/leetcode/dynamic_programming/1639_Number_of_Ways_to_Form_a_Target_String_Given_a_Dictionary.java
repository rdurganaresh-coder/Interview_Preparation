package com.leetcode.dynamic_programming;

class Solution1639 {
    private int m;
    private int n;
    private String target;
    private Integer[][] f;
    private int[][] cnt;
    private final int mod = (int) 1e9 + 7;

    public int numWays(String[] words, String target) {
        m = target.length();
        n = words[0].length();
        f = new Integer[m][n];
        this.target = target;
        cnt = new int[n][26];
        for (var w : words) {
            for (int j = 0; j < n; ++j) {
                cnt[j][w.charAt(j) - 'a']++;
            }
        }
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= m) {
            return 1;
        }
        if (j >= n) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        long ans = dfs(i, j + 1);
        ans += 1L * dfs(i + 1, j + 1) * cnt[j][target.charAt(i) - 'a'];
        ans %= mod;
        return f[i][j] = (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1639 _tcSol = new Solution1639();
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
