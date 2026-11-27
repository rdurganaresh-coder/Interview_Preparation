package com.leetcode.graphs_shortest_path;

class Solution3311 {
    public int[][] constructGridLayout(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }

        int[] deg = new int[5];
        Arrays.fill(deg, -1);

        for (int x = 0; x < n; x++) {
            deg[g[x].size()] = x;
        }

        List<Integer> row = new ArrayList<>();
        if (deg[1] != -1) {
            row.add(deg[1]);
        } else if (deg[4] == -1) {
            int x = deg[2];
            for (int y : g[x]) {
                if (g[y].size() == 2) {
                    row.add(x);
                    row.add(y);
                    break;
                }
            }
        } else {
            int x = deg[2];
            row.add(x);
            int pre = x;
            x = g[x].get(0);
            while (g[x].size() > 2) {
                row.add(x);
                for (int y : g[x]) {
                    if (y != pre && g[y].size() < 4) {
                        pre = x;
                        x = y;
                        break;
                    }
                }
            }
            row.add(x);
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(row));

        boolean[] vis = new boolean[n];
        int rowSize = row.size();
        for (int i = 0; i < n / rowSize - 1; i++) {
            for (int x : row) {
                vis[x] = true;
            }
            List<Integer> nxt = new ArrayList<>();
            for (int x : row) {
                for (int y : g[x]) {
                    if (!vis[y]) {
                        nxt.add(y);
                        break;
                    }
                }
            }
            res.add(new ArrayList<>(nxt));
            row = nxt;
        }

        int[][] ans = new int[res.size()][rowSize];
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < rowSize; j++) {
                ans[i][j] = res.get(i).get(j);
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
        Solution3311 _tcSol = new Solution3311();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, edges = [[0,1],[0,2],[1,3],[2,3]]");
        try {
            int n = 4;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.constructGridLayout(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,1],[2,0]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, edges = [[0,1],[1,3],[2,3],[2,4]]");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 3}, new int[]{2, 3}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.constructGridLayout(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[4,2,3,1,0]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 9, edges = [[0,1],[0,4],[0,5],[1,7],[2,3],[2,4],[2,5],[3,6],[4,6],[4,7],[6,8],[7,8]]");
        try {
            int n = 9;
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 4}, new int[]{0, 5}, new int[]{1, 7}, new int[]{2, 3}, new int[]{2, 4}, new int[]{2, 5}, new int[]{3, 6}, new int[]{4, 6}, new int[]{4, 7}, new int[]{6, 8}, new int[]{7, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.constructGridLayout(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[8,6,3],[7,4,2],[1,0,5]]");
        System.out.println();
    }
}
