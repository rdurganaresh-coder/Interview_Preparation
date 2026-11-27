package com.leetcode.backtracking;

class Solution3437 {
    private List<int[]> ans = new ArrayList<>();
    private boolean[] vis;
    private int[] t;
    private int n;

    public int[][] permute(int n) {
        this.n = n;
        t = new int[n];
        vis = new boolean[n + 1];
        dfs(0);
        return ans.toArray(new int[0][]);
    }

    private void dfs(int i) {
        if (i >= n) {
            ans.add(t.clone());
            return;
        }
        for (int j = 1; j <= n; ++j) {
            if (!vis[j] && (i == 0 || t[i - 1] % 2 != j % 2)) {
                vis[j] = true;
                t[i] = j;
                dfs(i + 1);
                vis[j] = false;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3437 _tcSol = new Solution3437();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4");
        try {
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.permute(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2,3,4],[1,4,3,2],[2,1,4,3],[2,3,4,1],[3,2,1,4],[3,4,1,2],[4,1,2,3],[4,3,2,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.permute(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2],[2,1]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3");
        try {
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.permute(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2,3],[3,2,1]]");
        System.out.println();
    }
}
