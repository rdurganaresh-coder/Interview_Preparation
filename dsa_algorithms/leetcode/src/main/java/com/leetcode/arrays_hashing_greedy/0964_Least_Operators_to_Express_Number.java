package com.leetcode.arrays_hashing_greedy;

class Solution0964 {
    private int x;
    private Map<Integer, Integer> f = new HashMap<>();

    public int leastOpsExpressTarget(int x, int target) {
        this.x = x;
        return dfs(target);
    }

    private int dfs(int v) {
        if (x >= v) {
            return Math.min(v * 2 - 1, 2 * (x - v));
        }
        if (f.containsKey(v)) {
            return f.get(v);
        }
        int k = 2;
        long y = (long) x * x;
        while (y < v) {
            y *= x;
            ++k;
        }
        int ans = k - 1 + dfs(v - (int) (y / x));
        if (y - v < v) {
            ans = Math.min(ans, k + dfs((int) y - v));
        }
        f.put(v, ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0964 _tcSol = new Solution0964();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = 3, target = 19");
        try {
            int x = 3;
            int target = 19;
            System.out.println("  Output  : " + _tcShow(_tcSol.leastOpsExpressTarget(x, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = 5, target = 501");
        try {
            int x = 5;
            int target = 501;
            System.out.println("  Output  : " + _tcShow(_tcSol.leastOpsExpressTarget(x, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "x = 100, target = 100000000");
        try {
            int x = 100;
            int target = 100000000;
            System.out.println("  Output  : " + _tcShow(_tcSol.leastOpsExpressTarget(x, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}