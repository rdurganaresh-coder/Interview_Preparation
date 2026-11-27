package com.leetcode.graphs_shortest_path;

class Solution2421 {
    private int[] p;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        p = new int[n];
        int[][] arr = new int[n][2];
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        Map<Integer, Map<Integer, Integer>> size = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            p[i] = i;
            arr[i] = new int[] {vals[i], i};
            size.computeIfAbsent(i, k -> new HashMap<>()).put(vals[i], 1);
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int ans = n;
        for (var e : arr) {
            int v = e[0], a = e[1];
            for (int b : g[a]) {
                if (vals[b] > v) {
                    continue;
                }
                int pa = find(a), pb = find(b);
                if (pa != pb) {
                    ans += size.get(pa).getOrDefault(v, 0) * size.get(pb).getOrDefault(v, 0);
                    p[pa] = pb;
                    size.get(pb).put(
                        v, size.get(pb).getOrDefault(v, 0) + size.get(pa).getOrDefault(v, 0));
                }
            }
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2421 _tcSol = new Solution2421();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "vals = [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]]");
        try {
            int[] vals = new int[]{1, 3, 2, 1, 3};
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{2, 3}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfGoodPaths(vals, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "vals = [1,1,2,2,3], edges = [[0,1],[1,2],[2,3],[2,4]]");
        try {
            int[] vals = new int[]{1, 1, 2, 2, 3};
            int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfGoodPaths(vals, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "vals = [1], edges = []");
        try {
            int[] vals = new int[]{1};
            int[][] edges = new int[][]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfGoodPaths(vals, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}