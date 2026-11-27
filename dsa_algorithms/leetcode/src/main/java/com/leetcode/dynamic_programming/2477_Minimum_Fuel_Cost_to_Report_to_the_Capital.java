package com.leetcode.dynamic_programming;

class Solution2477 {
    private List<Integer>[] g;
    private int seats;
    private long ans;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        this.seats = seats;
        for (var e : roads) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        dfs(0, -1);
        return ans;
    }

    private int dfs(int a, int fa) {
        int sz = 1;
        for (int b : g[a]) {
            if (b != fa) {
                int t = dfs(b, a);
                ans += (t + seats - 1) / seats;
                sz += t;
            }
        }
        return sz;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2477 _tcSol = new Solution2477();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "roads = [[0,1],[0,2],[0,3]], seats = 5");
        try {
            int[][] roads = new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}};
            int seats = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumFuelCost(roads, seats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2");
        try {
            int[][] roads = new int[][]{new int[]{3, 1}, new int[]{3, 2}, new int[]{1, 0}, new int[]{0, 4}, new int[]{0, 5}, new int[]{4, 6}};
            int seats = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumFuelCost(roads, seats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "roads = [], seats = 1");
        try {
            int[][] roads = new int[][]{};
            int seats = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumFuelCost(roads, seats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
