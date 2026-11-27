package com.leetcode.arrays_hashing_greedy;

class Solution1467 {
    private int n;
    private long[][] c;
    private int[] balls;
    private Map<List<Integer>, Long> f = new HashMap<>();

    public double getProbability(int[] balls) {
        int mx = 0;
        for (int x : balls) {
            n += x;
            mx = Math.max(mx, x);
        }
        n >>= 1;
        this.balls = balls;
        int m = Math.max(mx, n << 1);
        c = new long[m + 1][m + 1];
        for (int i = 0; i <= m; ++i) {
            c[i][0] = 1;
            for (int j = 1; j <= i; ++j) {
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
            }
        }
        return dfs(0, n, 0) * 1.0 / c[n << 1][n];
    }

    private long dfs(int i, int j, int diff) {
        if (i >= balls.length) {
            return j == 0 && diff == 0 ? 1 : 0;
        }
        if (j < 0) {
            return 0;
        }
        List<Integer> key = List.of(i, j, diff);
        if (f.containsKey(key)) {
            return f.get(key);
        }
        long ans = 0;
        for (int x = 0; x <= balls[i]; ++x) {
            int y = x == balls[i] ? 1 : (x == 0 ? -1 : 0);
            ans += dfs(i + 1, j - x, diff + y) * c[balls[i]][x];
        }
        f.put(key, ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1467 _tcSol = new Solution1467();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "balls = [1,1]");
        try {
            int[] balls = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.getProbability(balls)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "balls = [2,1,1]");
        try {
            int[] balls = new int[]{2, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.getProbability(balls)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.66667");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "balls = [1,2,1,2]");
        try {
            int[] balls = new int[]{1, 2, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.getProbability(balls)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.60000");
        System.out.println();
    }
}