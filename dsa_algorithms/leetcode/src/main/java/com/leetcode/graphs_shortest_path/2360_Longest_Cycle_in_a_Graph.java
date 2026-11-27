package com.leetcode.graphs_shortest_path;

class Solution2360 {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            if (vis[i]) {
                continue;
            }
            int j = i;
            List<Integer> cycle = new ArrayList<>();
            for (; j != -1 && !vis[j]; j = edges[j]) {
                vis[j] = true;
                cycle.add(j);
            }
            if (j == -1) {
                continue;
            }
            for (int k = 0; k < cycle.size(); ++k) {
                if (cycle.get(k) == j) {
                    ans = Math.max(ans, cycle.size() - k);
                    break;
                }
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
        Solution2360 _tcSol = new Solution2360();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [3,3,4,2,3]");
        try {
            int[] edges = new int[]{3, 3, 4, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCycle(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [2,-1,3,1]");
        try {
            int[] edges = new int[]{2, -1, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCycle(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}