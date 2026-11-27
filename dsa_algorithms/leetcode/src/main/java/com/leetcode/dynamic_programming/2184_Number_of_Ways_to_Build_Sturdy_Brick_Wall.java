package com.leetcode.dynamic_programming;

class Solution2184 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private static final int MOD = (int) 1e9 + 7;
    private int width;
    private int[] bricks;

    public int buildWall(int height, int width, int[] bricks) {
        this.width = width;
        this.bricks = bricks;
        dfs(0);
        int n = res.size();
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            if (check(res.get(i), res.get(i))) {
                g[i].add(i);
            }
            for (int j = i + 1; j < n; ++j) {
                if (check(res.get(i), res.get(j))) {
                    g[i].add(j);
                    g[j].add(i);
                }
            }
        }
        int[][] dp = new int[height][n];
        for (int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < height; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k : g[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            ans = (ans + dp[height - 1][j]) % MOD;
        }
        return ans;
    }

    private boolean check(List<Integer> a, List<Integer> b) {
        int s1 = a.get(0);
        int s2 = b.get(0);
        int i = 1, j = 1;
        while (i < a.size() && j < b.size()) {
            if (s1 == s2) {
                return false;
            }
            if (s1 < s2) {
                s1 += a.get(i++);
            } else {
                s2 += b.get(j++);
            }
        }
        return true;
    }

    private void dfs(int v) {
        if (v > width) {
            return;
        }
        if (v == width) {
            res.add(new ArrayList<>(t));
            return;
        }
        for (int x : bricks) {
            t.add(x);
            dfs(v + x);
            t.remove(t.size() - 1);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2184 _tcSol = new Solution2184();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "height = 2, width = 3, bricks = [1,2]");
        try {
            int height = 2;
            int width = 3;
            int[] bricks = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.buildWall(height, width, bricks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "height = 1, width = 1, bricks = [5]");
        try {
            int height = 1;
            int width = 1;
            int[] bricks = new int[]{5};
            System.out.println("  Output  : " + _tcShow(_tcSol.buildWall(height, width, bricks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}