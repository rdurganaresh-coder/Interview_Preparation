package com.leetcode.dynamic_programming;

class Solution0983_2 {
    public int mincostTickets(int[] days, int[] costs) {
        int m = days[days.length - 1];
        int[] f = new int[m + 1];
        final int[] valid = {1, 7, 30};
        for (int i = 1, j = 0; i <= m; ++i) {
            if (i == days[j]) {
                f[i] = Integer.MAX_VALUE;
                for (int k = 0; k < 3; ++k) {
                    int c = costs[k], v = valid[k];
                    f[i] = Math.min(f[i], f[Math.max(0, i - v)] + c);
                }
                ++j;
            } else {
                f[i] = f[i - 1];
            }
        }
        return f[m];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0983_2 _tcSol = new Solution0983_2();
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