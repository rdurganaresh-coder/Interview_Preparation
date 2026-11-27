package com.leetcode.arrays_hashing_greedy;

class Solution3383 {
    private int[] vis;
    private List<Integer>[] g;
    private List<Integer> seq = new ArrayList<>();

    public int minRunesToAdd(int n, int[] crystals, int[] flowFrom, int[] flowTo) {
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < flowFrom.length; ++i) {
            g[flowFrom[i]].add(flowTo[i]);
        }
        Deque<Integer> q = new ArrayDeque<>();
        vis = new int[n];
        for (int i : crystals) {
            vis[i] = 1;
            q.offer(i);
        }
        bfs(q);
        for (int i = 0; i < n; ++i) {
            if (vis[i] == 0) {
                dfs(i);
            }
        }
        int ans = 0;
        for (int i = seq.size() - 1; i >= 0; --i) {
            int a = seq.get(i);
            if (vis[a] == 2) {
                vis[a] = 1;
                q.clear();
                q.offer(a);
                bfs(q);
                ++ans;
            }
        }
        return ans;
    }

    private void bfs(Deque<Integer> q) {
        while (!q.isEmpty()) {
            int a = q.poll();
            for (int b : g[a]) {
                if (vis[b] == 1) {
                    continue;
                }
                vis[b] = 1;
                q.offer(b);
            }
        }
    }

    private void dfs(int a) {
        vis[a] = 2;
        for (int b : g[a]) {
            if (vis[b] > 0) {
                continue;
            }
            dfs(b);
        }
        seq.add(a);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3383 _tcSol = new Solution3383();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, crystals = [0], flowFrom = [0,1,2,3], flowTo = [1,2,3,0]");
        try {
            int n = 6;
            int[] crystals = new int[]{0};
            int[] flowFrom = new int[]{0, 1, 2, 3};
            int[] flowTo = new int[]{1, 2, 3, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minRunesToAdd(n, crystals, flowFrom, flowTo)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 7, crystals = [3,5], flowFrom = [0,1,2,3,5], flowTo = [1,2,0,4,6]");
        try {
            int n = 7;
            int[] crystals = new int[]{3, 5};
            int[] flowFrom = new int[]{0, 1, 2, 3, 5};
            int[] flowTo = new int[]{1, 2, 0, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.minRunesToAdd(n, crystals, flowFrom, flowTo)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
