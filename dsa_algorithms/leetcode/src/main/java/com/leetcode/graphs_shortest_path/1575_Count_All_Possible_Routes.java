package com.leetcode.graphs_shortest_path;

class Solution1575 {
    private int[] locations;
    private int finish;
    private int n;
    private Integer[][] f;
    private final int mod = (int) 1e9 + 7;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        n = locations.length;
        this.locations = locations;
        this.finish = finish;
        f = new Integer[n][fuel + 1];
        return dfs(start, fuel);
    }

    private int dfs(int i, int k) {
        if (k < Math.abs(locations[i] - locations[finish])) {
            return 0;
        }
        if (f[i][k] != null) {
            return f[i][k];
        }
        int ans = i == finish ? 1 : 0;
        for (int j = 0; j < n; ++j) {
            if (j != i) {
                ans = (ans + dfs(j, k - Math.abs(locations[i] - locations[j]))) % mod;
            }
        }
        return f[i][k] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1575 _tcSol = new Solution1575();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5");
        try {
            int[] locations = new int[]{2, 3, 6, 8, 4};
            int start = 1;
            int finish = 3;
            int fuel = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countRoutes(locations, start, finish, fuel)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "locations = [4,3,1], start = 1, finish = 0, fuel = 6");
        try {
            int[] locations = new int[]{4, 3, 1};
            int start = 1;
            int finish = 0;
            int fuel = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.countRoutes(locations, start, finish, fuel)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "locations = [5,2,1], start = 0, finish = 2, fuel = 3");
        try {
            int[] locations = new int[]{5, 2, 1};
            int start = 0;
            int finish = 2;
            int fuel = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.countRoutes(locations, start, finish, fuel)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}