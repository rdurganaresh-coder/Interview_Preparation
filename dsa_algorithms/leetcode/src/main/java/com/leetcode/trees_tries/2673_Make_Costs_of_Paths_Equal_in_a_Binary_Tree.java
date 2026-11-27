package com.leetcode.trees_tries;

class Solution2673 {
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n >> 1; i > 0; --i) {
            int l = i << 1, r = i << 1 | 1;
            ans += Math.abs(cost[l - 1] - cost[r - 1]);
            cost[i - 1] += Math.max(cost[l - 1], cost[r - 1]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2673 _tcSol = new Solution2673();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 7, cost = [1,5,2,2,3,3,1]");
        try {
            int n = 7;
            int[] cost = new int[]{1, 5, 2, 2, 3, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minIncrements(n, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, cost = [5,3,3]");
        try {
            int n = 3;
            int[] cost = new int[]{5, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minIncrements(n, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}