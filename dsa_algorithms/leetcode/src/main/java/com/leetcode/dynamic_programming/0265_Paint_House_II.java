package com.leetcode.dynamic_programming;

class Solution0265 {
    public int minCostII(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        int[] f = costs[0].clone();
        for (int i = 1; i < n; ++i) {
            int[] g = costs[i].clone();
            for (int j = 0; j < k; ++j) {
                int t = Integer.MAX_VALUE;
                for (int h = 0; h < k; ++h) {
                    if (h != j) {
                        t = Math.min(t, f[h]);
                    }
                }
                g[j] += t;
            }
            f = g;
        }
        return Arrays.stream(f).min().getAsInt();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0265 _tcSol = new Solution0265();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "costs = [[1,5,3],[2,9,4]]");
        try {
            int[][] costs = new int[][]{new int[]{1, 5, 3}, new int[]{2, 9, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCostII(costs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "costs = [[1,3],[2,4]]");
        try {
            int[][] costs = new int[][]{new int[]{1, 3}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCostII(costs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}