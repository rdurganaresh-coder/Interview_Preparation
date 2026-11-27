package com.leetcode.sql_database;

class Solution1349 {
    private Integer[][] f;
    private int n;
    private int[] ss;

    public int maxStudents(char[][] seats) {
        int m = seats.length;
        n = seats[0].length;
        ss = new int[m];
        f = new Integer[1 << n][m];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (seats[i][j] == '.') {
                    ss[i] |= 1 << j;
                }
            }
        }
        return dfs(ss[0], 0);
    }

    private int dfs(int seat, int i) {
        if (f[seat][i] != null) {
            return f[seat][i];
        }
        int ans = 0;
        for (int mask = 0; mask < 1 << n; ++mask) {
            if ((seat | mask) != seat || (mask & (mask << 1)) != 0) {
                continue;
            }
            int cnt = Integer.bitCount(mask);
            if (i == ss.length - 1) {
                ans = Math.max(ans, cnt);
            } else {
                int nxt = ss[i + 1];
                nxt &= ~(mask << 1);
                nxt &= ~(mask >> 1);
                ans = Math.max(ans, cnt + dfs(nxt, i + 1));
            }
        }
        return f[seat][i] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1349 _tcSol = new Solution1349();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "seats = [[\"#\",\".\",\"#\",\"#\",\".\",\"#\"], [\".\",\"#\",\"#\",\"#\",\"#\",\".\"], [\"#\",\".\",\"#\",\"#\",\".\",\"#\"]]");
        try {
            char[][] seats = new char[][]{new char[]{'#', '.', '#', '#', '.', '#'}, new char[]{'.', '#', '#', '#', '#', '.'}, new char[]{'#', '.', '#', '#', '.', '#'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxStudents(seats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "seats = [[\".\",\"#\"], [\"#\",\"#\"], [\"#\",\".\"], [\"#\",\"#\"], [\".\",\"#\"]]");
        try {
            char[][] seats = new char[][]{new char[]{'.', '#'}, new char[]{'#', '#'}, new char[]{'#', '.'}, new char[]{'#', '#'}, new char[]{'.', '#'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxStudents(seats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "seats = [[\"#\",\".\",\".\",\".\",\"#\"], [\".\",\"#\",\".\",\"#\",\".\"], [\".\",\".\",\"#\",\".\",\".\"], [\".\",\"#\",\".\",\"#\",\".\"], [\"#\",\".\",\".\",\".\",\"#\"]]");
        try {
            char[][] seats = new char[][]{new char[]{'#', '.', '.', '.', '#'}, new char[]{'.', '#', '.', '#', '.'}, new char[]{'.', '.', '#', '.', '.'}, new char[]{'.', '#', '.', '#', '.'}, new char[]{'#', '.', '.', '.', '#'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxStudents(seats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}