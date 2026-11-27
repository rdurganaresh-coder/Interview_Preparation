package com.leetcode.arrays_hashing_greedy;

class Solution2101 {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int[] p1 = bombs[i], p2 = bombs[j];
                double dist = Math.hypot(p1[0] - p2[0], p1[1] - p2[1]);
                if (dist <= p1[2]) {
                    g[i].add(j);
                }
                if (dist <= p2[2]) {
                    g[j].add(i);
                }
            }
        }
        int ans = 0;
        boolean[] vis = new boolean[n];
        for (int k = 0; k < n; ++k) {
            Arrays.fill(vis, false);
            vis[k] = true;
            int cnt = 0;
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(k);
            while (!q.isEmpty()) {
                int i = q.poll();
                ++cnt;
                for (int j : g[i]) {
                    if (!vis[j]) {
                        vis[j] = true;
                        q.offer(j);
                    }
                }
            }
            if (cnt == n) {
                return n;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2101 _tcSol = new Solution2101();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "bombs = [[2,1,3],[6,1,4]]");
        try {
            int[][] bombs = new int[][]{new int[]{2, 1, 3}, new int[]{6, 1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumDetonation(bombs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "bombs = [[1,1,5],[10,10,5]]");
        try {
            int[][] bombs = new int[][]{new int[]{1, 1, 5}, new int[]{10, 10, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumDetonation(bombs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]");
        try {
            int[][] bombs = new int[][]{new int[]{1, 2, 3}, new int[]{2, 3, 1}, new int[]{3, 4, 2}, new int[]{4, 5, 3}, new int[]{5, 6, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumDetonation(bombs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}