package com.leetcode.sliding_window_two_pointers;

class Solution0131 {
    private int n;
    private String s;
    private boolean[][] f;
    private List<String> t = new ArrayList<>();
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }
        this.s = s;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                t.add(s.substring(i, j + 1));
                dfs(j + 1);
                t.remove(t.size() - 1);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0131 _tcSol = new Solution0131();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aab\"");
        try {
            String s = "aab";
            System.out.println("  Output  : " + _tcShow(_tcSol.partition(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"a\",\"a\",\"b\"],[\"aa\",\"b\"]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"a\"");
        try {
            String s = "a";
            System.out.println("  Output  : " + _tcShow(_tcSol.partition(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[\"a\"]]");
        System.out.println();
    }
}