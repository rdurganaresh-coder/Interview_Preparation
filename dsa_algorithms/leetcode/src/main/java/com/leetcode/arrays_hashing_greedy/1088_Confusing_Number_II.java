package com.leetcode.arrays_hashing_greedy;

class Solution1088 {
    private final int[] d = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
    private String s;

    public int confusingNumberII(int n) {
        s = String.valueOf(n);
        return dfs(0, 1, 0);
    }

    private int dfs(int pos, int limit, int x) {
        if (pos >= s.length()) {
            return check(x) ? 1 : 0;
        }
        int up = limit == 1 ? s.charAt(pos) - '0' : 9;
        int ans = 0;
        for (int i = 0; i <= up; ++i) {
            if (d[i] != -1) {
                ans += dfs(pos + 1, limit == 1 && i == up ? 1 : 0, x * 10 + i);
            }
        }
        return ans;
    }

    private boolean check(int x) {
        int y = 0;
        for (int t = x; t > 0; t /= 10) {
            int v = t % 10;
            y = y * 10 + d[v];
        }
        return x != y;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1088 _tcSol = new Solution1088();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 20");
        try {
            int n = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.confusingNumberII(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 100");
        try {
            int n = 100;
            System.out.println("  Output  : " + _tcShow(_tcSol.confusingNumberII(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();
    }
}