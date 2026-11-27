package com.leetcode.trees_tries;

class Solution3067 {
    private int signalSpeed;
    private List<int[]>[] g;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        g = new List[n];
        this.signalSpeed = signalSpeed;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1], w = e[2];
            g[a].add(new int[] {b, w});
            g[b].add(new int[] {a, w});
        }
        int[] ans = new int[n];
        for (int a = 0; a < n; ++a) {
            int s = 0;
            for (var e : g[a]) {
                int b = e[0], w = e[1];
                int t = dfs(b, a, w);
                ans[a] += s * t;
                s += t;
            }
        }
        return ans;
    }

    private int dfs(int a, int fa, int ws) {
        int cnt = ws % signalSpeed == 0 ? 1 : 0;
        for (var e : g[a]) {
            int b = e[0], w = e[1];
            if (b != fa) {
                cnt += dfs(b, a, ws + w);
            }
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3067 _tcSol = new Solution3067();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [[0,1,1],[1,2,5],[2,3,13],[3,4,9],[4,5,2]], signalSpeed = 1");
        try {
            int[][] edges = new int[][]{new int[]{0, 1, 1}, new int[]{1, 2, 5}, new int[]{2, 3, 13}, new int[]{3, 4, 9}, new int[]{4, 5, 2}};
            int signalSpeed = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairsOfConnectableServers(edges, signalSpeed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,4,6,6,4,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [[0,6,3],[6,5,3],[0,3,1],[3,2,7],[3,1,6],[3,4,2]], signalSpeed = 3");
        try {
            int[][] edges = new int[][]{new int[]{0, 6, 3}, new int[]{6, 5, 3}, new int[]{0, 3, 1}, new int[]{3, 2, 7}, new int[]{3, 1, 6}, new int[]{3, 4, 2}};
            int signalSpeed = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairsOfConnectableServers(edges, signalSpeed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,0,0,0,0,0,2]");
        System.out.println();
    }
}
