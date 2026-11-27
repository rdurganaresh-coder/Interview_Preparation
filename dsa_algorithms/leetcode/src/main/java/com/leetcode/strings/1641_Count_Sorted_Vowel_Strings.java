package com.leetcode.strings;

class Solution1641 {
    private Integer[][] f;
    private int n;

    public int countVowelStrings(int n) {
        this.n = n;
        f = new Integer[n][5];
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= n) {
            return 1;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = 0;
        for (int k = j; k < 5; ++k) {
            ans += dfs(i + 1, k);
        }
        return f[i][j] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1641 _tcSol = new Solution1641();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countVowelStrings(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countVowelStrings(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 33");
        try {
            int n = 33;
            System.out.println("  Output  : " + _tcShow(_tcSol.countVowelStrings(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "66045");
        System.out.println();
    }
}