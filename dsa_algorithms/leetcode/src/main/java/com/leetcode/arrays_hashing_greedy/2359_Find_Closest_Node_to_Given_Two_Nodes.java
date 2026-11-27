package com.leetcode.arrays_hashing_greedy;

class Solution2359 {
    private int n;
    private List<Integer>[] g;

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            if (edges[i] != -1) {
                g[i].add(edges[i]);
            }
        }
        int[] d1 = f(node1);
        int[] d2 = f(node2);
        int d = 1 << 30;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            int t = Math.max(d1[i], d2[i]);
            if (t < d) {
                d = t;
                ans = i;
            }
        }
        return ans;
    }

    private int[] f(int i) {
        int[] dist = new int[n];
        Arrays.fill(dist, 1 << 30);
        dist[i] = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(i);
        while (!q.isEmpty()) {
            i = q.poll();
            for (int j : g[i]) {
                if (dist[j] == 1 << 30) {
                    dist[j] = dist[i] + 1;
                    q.offer(j);
                }
            }
        }
        return dist;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2359 _tcSol = new Solution2359();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [2,2,3,-1], node1 = 0, node2 = 1");
        try {
            int[] edges = new int[]{2, 2, 3, -1};
            int node1 = 0;
            int node2 = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestMeetingNode(edges, node1, node2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [1,2,-1], node1 = 0, node2 = 2");
        try {
            int[] edges = new int[]{1, 2, -1};
            int node1 = 0;
            int node2 = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.closestMeetingNode(edges, node1, node2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}