package com.leetcode.strings;

class Solution0471 {
    private String s;
    private String[][] f;

    public String encode(String s) {
        this.s = s;
        int n = s.length();
        f = new String[n][n];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                f[i][j] = g(i, j);
                if (j - i + 1 > 4) {
                    for (int k = i; k < j; ++k) {
                        String t = f[i][k] + f[k + 1][j];
                        if (f[i][j].length() > t.length()) {
                            f[i][j] = t;
                        }
                    }
                }
            }
        }
        return f[0][n - 1];
    }

    private String g(int i, int j) {
        String t = s.substring(i, j + 1);
        if (t.length() < 5) {
            return t;
        }
        int k = (t + t).indexOf(t, 1);
        if (k < t.length()) {
            int cnt = t.length() / k;
            return String.format("%d[%s]", cnt, f[i][i + k - 1]);
        }
        return t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0471 _tcSol = new Solution0471();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aaa\"");
        try {
            String s = "aaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.encode(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaa\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaaaa\"");
        try {
            String s = "aaaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.encode(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"5[a]\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"aaaaaaaaaa\"");
        try {
            String s = "aaaaaaaaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.encode(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"10[a]\"");
        System.out.println();
    }
}