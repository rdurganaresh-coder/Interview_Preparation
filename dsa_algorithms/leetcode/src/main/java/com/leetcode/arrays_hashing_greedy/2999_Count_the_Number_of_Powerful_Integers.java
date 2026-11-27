package com.leetcode.arrays_hashing_greedy;

class Solution2999 {
    private String s;
    private String t;
    private Long[] f;
    private int limit;

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.s = s;
        this.limit = limit;
        t = String.valueOf(start - 1);
        f = new Long[20];
        long a = dfs(0, true);
        t = String.valueOf(finish);
        f = new Long[20];
        long b = dfs(0, true);
        return b - a;
    }

    private long dfs(int pos, boolean lim) {
        if (t.length() < s.length()) {
            return 0;
        }
        if (!lim && f[pos] != null) {
            return f[pos];
        }
        if (t.length() - pos == s.length()) {
            return lim ? (s.compareTo(t.substring(pos)) <= 0 ? 1 : 0) : 1;
        }
        int up = lim ? t.charAt(pos) - '0' : 9;
        up = Math.min(up, limit);
        long ans = 0;
        for (int i = 0; i <= up; ++i) {
            ans += dfs(pos + 1, lim && i == (t.charAt(pos) - '0'));
        }
        if (!lim) {
            f[pos] = ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2999 _tcSol = new Solution2999();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "start = 1, finish = 6000, limit = 4, s = \"124\"");
        try {
            long start = 1L;
            long finish = 6000L;
            int limit = 4;
            String s = "124";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPowerfulInt(start, finish, limit, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "start = 15, finish = 215, limit = 6, s = \"10\"");
        try {
            long start = 15L;
            long finish = 215L;
            int limit = 6;
            String s = "10";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPowerfulInt(start, finish, limit, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "start = 1000, finish = 2000, limit = 4, s = \"3000\"");
        try {
            long start = 1000L;
            long finish = 2000L;
            int limit = 4;
            String s = "3000";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPowerfulInt(start, finish, limit, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}