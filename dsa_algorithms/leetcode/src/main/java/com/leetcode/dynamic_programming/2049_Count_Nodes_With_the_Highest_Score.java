package com.leetcode.dynamic_programming;

class Solution2049 {
    private List<Integer>[] g;
    private int ans;
    private long mx;
    private int n;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parents[i]].add(i);
        }
        dfs(0, -1);
        return ans;
    }

    private int dfs(int i, int fa) {
        int cnt = 1;
        long score = 1;
        for (int j : g[i]) {
            if (j != fa) {
                int t = dfs(j, i);
                cnt += t;
                score *= t;
            }
        }
        if (n - cnt > 0) {
            score *= n - cnt;
        }
        if (mx < score) {
            mx = score;
            ans = 1;
        } else if (mx == score) {
            ++ans;
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2049 _tcSol = new Solution2049();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "parents = [-1,2,0,2,0]");
        try {
            int[] parents = new int[]{-1, 2, 0, 2, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.countHighestScoreNodes(parents)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "parents = [-1,2,0]");
        try {
            int[] parents = new int[]{-1, 2, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.countHighestScoreNodes(parents)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
