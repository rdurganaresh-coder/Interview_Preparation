package com.leetcode.trees_tries;

class Solution3067_2 {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<int[]>[] g = new List[n];
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
                int t = count(g, e[0], a, e[1], signalSpeed);
                ans[a] += s * t;
                s += t;
            }
        }
        return ans;
    }

    private int count(List<int[]>[] g, int start, int fa, int dist, int signalSpeed) {
        int cnt = 0;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {start, fa, dist});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int a = cur[0], parent = cur[1], ws = cur[2];
            if (ws % signalSpeed == 0) {
                ++cnt;
            }
            for (var e : g[a]) {
                int b = e[0], w = e[1];
                if (b != parent) {
                    stk.push(new int[] {b, a, ws + w});
                }
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
        Solution3067_2 _tcSol = new Solution3067_2();
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
