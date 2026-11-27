package com.leetcode.graphs_shortest_path;

class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> { return a[0] - a[1] - (b[0] - b[1]); });
        int ans = 0;
        int n = costs.length >> 1;
        for (int i = 0; i < n; ++i) {
            ans += costs[i][0] + costs[i + n][1];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1029 _tcSol = new Solution1029();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "costs = [[10,20],[30,200],[400,50],[30,20]]");
        try {
            int[][] costs = new int[][]{new int[]{10, 20}, new int[]{30, 200}, new int[]{400, 50}, new int[]{30, 20}};
            System.out.println("  Output  : " + _tcShow(_tcSol.twoCitySchedCost(costs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "110");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]");
        try {
            int[][] costs = new int[][]{new int[]{259, 770}, new int[]{448, 54}, new int[]{926, 667}, new int[]{184, 139}, new int[]{840, 118}, new int[]{577, 469}};
            System.out.println("  Output  : " + _tcShow(_tcSol.twoCitySchedCost(costs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1859");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]");
        try {
            int[][] costs = new int[][]{new int[]{515, 563}, new int[]{451, 713}, new int[]{537, 709}, new int[]{343, 819}, new int[]{855, 779}, new int[]{457, 60}, new int[]{650, 359}, new int[]{631, 42}};
            System.out.println("  Output  : " + _tcShow(_tcSol.twoCitySchedCost(costs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3086");
        System.out.println();
    }
}