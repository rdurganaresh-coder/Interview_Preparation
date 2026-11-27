package com.leetcode.strings;

class Solution2896 {
    private List<Integer> idx = new ArrayList<>();
    private Integer[][] f;
    private int x;

    public int minOperations(String s1, String s2, int x) {
        int n = s1.length();
        for (int i = 0; i < n; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                idx.add(i);
            }
        }
        int m = idx.size();
        if (m % 2 == 1) {
            return -1;
        }
        this.x = x;
        f = new Integer[m][m];
        return dfs(0, m - 1);
    }

    private int dfs(int i, int j) {
        if (i > j) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        f[i][j] = dfs(i + 1, j - 1) + x;
        f[i][j] = Math.min(f[i][j], dfs(i + 2, j) + idx.get(i + 1) - idx.get(i));
        f[i][j] = Math.min(f[i][j], dfs(i, j - 2) + idx.get(j) - idx.get(j - 1));
        return f[i][j];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2896 _tcSol = new Solution2896();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"1100011000\", s2 = \"0101001010\", x = 2");
        try {
            String s1 = "1100011000";
            String s2 = "0101001010";
            int x = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(s1, s2, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"10110\", s2 = \"00011\", x = 4");
        try {
            String s1 = "10110";
            String s2 = "00011";
            int x = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(s1, s2, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}