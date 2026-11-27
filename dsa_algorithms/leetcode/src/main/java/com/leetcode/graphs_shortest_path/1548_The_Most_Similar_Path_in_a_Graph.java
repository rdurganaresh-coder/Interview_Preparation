package com.leetcode.graphs_shortest_path;

class Solution1548 {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] r : roads) {
            int a = r[0], b = r[1];
            g[a].add(b);
            g[b].add(a);
        }
        int m = targetPath.length;
        final int inf = 1 << 30;
        int[][] f = new int[m][n];
        int[][] pre = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(f[i], inf);
            Arrays.fill(pre[i], -1);
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = targetPath[0].equals(names[j]) ? 0 : 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k : g[j]) {
                    int t = f[i - 1][k] + (targetPath[i].equals(names[j]) ? 0 : 1);
                    if (t < f[i][j]) {
                        f[i][j] = t;
                        pre[i][j] = k;
                    }
                }
            }
        }
        int mi = inf, k = 0;
        for (int j = 0; j < n; ++j) {
            if (f[m - 1][j] < mi) {
                mi = f[m - 1][j];
                k = j;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = m - 1; i >= 0; --i) {
            ans.add(k);
            k = pre[i][k];
        }
        Collections.reverse(ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1548 _tcSol = new Solution1548();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, roads = [[0,2],[0,3],[1,2],[1,3],[1,4],[2,4]], names = [\"ATL\",\"PEK\",\"LAX\",\"DXB\",\"HND\"], targetPath = [\"ATL\",\"DXB\",\"HND\",\"LAX\"]");
        try {
            int n = 5;
            int[][] roads = new int[][]{new int[]{0, 2}, new int[]{0, 3}, new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 4}};
            String[] names = new String[]{"ATL", "PEK", "LAX", "DXB", "HND"};
            String[] targetPath = new String[]{"ATL", "DXB", "HND", "LAX"};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostSimilar(n, roads, names, targetPath)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2,4,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, roads = [[1,0],[2,0],[3,0],[2,1],[3,1],[3,2]], names = [\"ATL\",\"PEK\",\"LAX\",\"DXB\"], targetPath = [\"ABC\",\"DEF\",\"GHI\",\"JKL\",\"MNO\",\"PQR\",\"STU\",\"VWX\"]");
        try {
            int n = 4;
            int[][] roads = new int[][]{new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 0}, new int[]{2, 1}, new int[]{3, 1}, new int[]{3, 2}};
            String[] names = new String[]{"ATL", "PEK", "LAX", "DXB"};
            String[] targetPath = new String[]{"ABC", "DEF", "GHI", "JKL", "MNO", "PQR", "STU", "VWX"};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostSimilar(n, roads, names, targetPath)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,0,1,0,1,0,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 6, roads = [[0,1],[1,2],[2,3],[3,4],[4,5]], names = [\"ATL\",\"PEK\",\"LAX\",\"ATL\",\"DXB\",\"HND\"], targetPath = [\"ATL\",\"DXB\",\"HND\",\"DXB\",\"ATL\",\"LAX\",\"PEK\"]");
        try {
            int n = 6;
            int[][] roads = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 5}};
            String[] names = new String[]{"ATL", "PEK", "LAX", "ATL", "DXB", "HND"};
            String[] targetPath = new String[]{"ATL", "DXB", "HND", "DXB", "ATL", "LAX", "PEK"};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostSimilar(n, roads, names, targetPath)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,4,5,4,3,2,1]");
        System.out.println();
    }
}