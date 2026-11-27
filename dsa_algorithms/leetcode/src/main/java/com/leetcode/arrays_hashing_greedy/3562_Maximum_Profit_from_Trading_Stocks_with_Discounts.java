package com.leetcode.arrays_hashing_greedy;

class Solution3562 {
    private List<Integer>[] g;
    private int[] present;
    private int[] future;
    private int budget;

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.present = present;
        this.future = future;
        this.budget = budget;

        g = new ArrayList[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());

        for (int[] e : hierarchy) {
            g[e[0]].add(e[1]);
        }

        return dfs(1)[budget][0];
    }

    private int[][] dfs(int u) {
        int[][] nxt = new int[budget + 1][2];

        for (int v : g[u]) {
            int[][] fv = dfs(v);
            for (int j = budget; j >= 0; j--) {
                for (int jv = 0; jv <= j; jv++) {
                    for (int pre = 0; pre < 2; pre++) {
                        int val = nxt[j - jv][pre] + fv[jv][pre];
                        if (val > nxt[j][pre]) {
                            nxt[j][pre] = val;
                        }
                    }
                }
            }
        }

        int[][] f = new int[budget + 1][2];
        int price = future[u - 1];

        for (int j = 0; j <= budget; j++) {
            for (int pre = 0; pre < 2; pre++) {
                int cost = present[u - 1] / (pre + 1);
                if (j >= cost) {
                    f[j][pre] = Math.max(nxt[j][0], nxt[j - cost][1] + (price - cost));
                } else {
                    f[j][pre] = nxt[j][0];
                }
            }
        }

        return f;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3562 _tcSol = new Solution3562();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, present = [1,2], future = [4,3], hierarchy = [[1,2]], budget = 3");
        try {
            int n = 2;
            int[] present = new int[]{1, 2};
            int[] future = new int[]{4, 3};
            int[][] hierarchy = new int[][]{new int[]{1, 2}};
            int budget = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(n, present, future, hierarchy, budget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, present = [3,4], future = [5,8], hierarchy = [[1,2]], budget = 4");
        try {
            int n = 2;
            int[] present = new int[]{3, 4};
            int[] future = new int[]{5, 8};
            int[][] hierarchy = new int[][]{new int[]{1, 2}};
            int budget = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(n, present, future, hierarchy, budget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, present = [4,6,8], future = [7,9,11], hierarchy = [[1,2],[1,3]], budget = 10");
        try {
            int n = 3;
            int[] present = new int[]{4, 6, 8};
            int[] future = new int[]{7, 9, 11};
            int[][] hierarchy = new int[][]{new int[]{1, 2}, new int[]{1, 3}};
            int budget = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(n, present, future, hierarchy, budget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "n = 3, present = [5,2,3], future = [8,5,6], hierarchy = [[1,2],[2,3]], budget = 7");
        try {
            int n = 3;
            int[] present = new int[]{5, 2, 3};
            int[] future = new int[]{8, 5, 6};
            int[][] hierarchy = new int[][]{new int[]{1, 2}, new int[]{2, 3}};
            int budget = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(n, present, future, hierarchy, budget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}
