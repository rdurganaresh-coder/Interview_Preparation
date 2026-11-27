package com.leetcode.dynamic_programming;

class Solution0983 {
    private final int[] valid = {1, 7, 30};
    private int[] days;
    private int[] costs;
    private Integer[] f;
    private int n;

    public int mincostTickets(int[] days, int[] costs) {
        n = days.length;
        f = new Integer[n];
        this.days = days;
        this.costs = costs;
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        f[i] = Integer.MAX_VALUE;
        for (int k = 0; k < 3; ++k) {
            int j = Arrays.binarySearch(days, days[i] + valid[k]);
            j = j < 0 ? -j - 1 : j;
            f[i] = Math.min(f[i], dfs(j) + costs[k]);
        }
        return f[i];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0983 _tcSol = new Solution0983();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "days = [1,4,6,7,8,20], costs = [2,7,15]");
        try {
            int[] days = new int[]{1, 4, 6, 7, 8, 20};
            int[] costs = new int[]{2, 7, 15};
            System.out.println("  Output  : " + _tcShow(_tcSol.mincostTickets(days, costs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]");
        try {
            int[] days = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
            int[] costs = new int[]{2, 7, 15};
            System.out.println("  Output  : " + _tcShow(_tcSol.mincostTickets(days, costs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();
    }
}