package com.leetcode.strings;

class Solution3316 {
    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        int m = source.length(), n = pattern.length();
        int[][] f = new int[m + 1][n + 1];
        final int inf = Integer.MAX_VALUE / 2;
        for (var g : f) {
            Arrays.fill(g, -inf);
        }
        f[0][0] = 0;
        int[] s = new int[m];
        for (int i : targetIndices) {
            s[i] = 1;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                f[i][j] = f[i - 1][j] + s[i - 1];
                if (j > 0 && source.charAt(i - 1) == pattern.charAt(j - 1)) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1]);
                }
            }
        }
        return f[m][n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3316 _tcSol = new Solution3316();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "source = \"abbaa\", pattern = \"aba\", targetIndices = [0,1,2]");
        try {
            String source = "abbaa";
            String pattern = "aba";
            int[] targetIndices = new int[]{0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRemovals(source, pattern, targetIndices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "source = \"bcda\", pattern = \"d\", targetIndices = [0,3]");
        try {
            String source = "bcda";
            String pattern = "d";
            int[] targetIndices = new int[]{0, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRemovals(source, pattern, targetIndices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "source = \"dda\", pattern = \"dda\", targetIndices = [0,1,2]");
        try {
            String source = "dda";
            String pattern = "dda";
            int[] targetIndices = new int[]{0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRemovals(source, pattern, targetIndices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "source = \"yeyeykyded\", pattern = \"yeyyd\", targetIndices = [0,2,3,4]");
        try {
            String source = "yeyeykyded";
            String pattern = "yeyyd";
            int[] targetIndices = new int[]{0, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRemovals(source, pattern, targetIndices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
