package com.leetcode.sql_database;

class Solution2127 {
    public int maximumInvitations(int[] favorite) {
        return Math.max(maxCycle(favorite), topologicalSort(favorite));
    }

    private int maxCycle(int[] fa) {
        int n = fa.length;
        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (vis[i]) {
                continue;
            }
            List<Integer> cycle = new ArrayList<>();
            int j = i;
            while (!vis[j]) {
                cycle.add(j);
                vis[j] = true;
                j = fa[j];
            }
            for (int k = 0; k < cycle.size(); ++k) {
                if (cycle.get(k) == j) {
                    ans = Math.max(ans, cycle.size() - k);
                }
            }
        }
        return ans;
    }

    private int topologicalSort(int[] fa) {
        int n = fa.length;
        int[] indeg = new int[n];
        int[] dist = new int[n];
        Arrays.fill(dist, 1);
        for (int v : fa) {
            indeg[v]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int i = q.pollFirst();
            dist[fa[i]] = Math.max(dist[fa[i]], dist[i] + 1);
            if (--indeg[fa[i]] == 0) {
                q.offer(fa[i]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (i == fa[fa[i]]) {
                ans += dist[i];
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2127 _tcSol = new Solution2127();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "favorite = [2,2,1,2]");
        try {
            int[] favorite = new int[]{2, 2, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumInvitations(favorite)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "favorite = [1,2,0]");
        try {
            int[] favorite = new int[]{1, 2, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumInvitations(favorite)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "favorite = [3,0,1,4,1]");
        try {
            int[] favorite = new int[]{3, 0, 1, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumInvitations(favorite)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}