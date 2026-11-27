package com.leetcode.sliding_window_two_pointers;

class Solution1312 {
    private Integer[][] f;
    private String s;

    public int minInsertions(String s) {
        this.s = s;
        int n = s.length();
        f = new Integer[n][n];
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = 1 << 30;
        if (s.charAt(i) == s.charAt(j)) {
            ans = dfs(i + 1, j - 1);
        } else {
            ans = Math.min(dfs(i + 1, j), dfs(i, j - 1)) + 1;
        }
        return f[i][j] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1312 _tcSol = new Solution1312();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"zzazz\"");
        try {
            String s = "zzazz";
            System.out.println("  Output  : " + _tcShow(_tcSol.minInsertions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"mbadm\"");
        try {
            String s = "mbadm";
            System.out.println("  Output  : " + _tcShow(_tcSol.minInsertions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"leetcode\"");
        try {
            String s = "leetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.minInsertions(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}