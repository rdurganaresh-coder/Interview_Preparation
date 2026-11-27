package com.leetcode.arrays_hashing_greedy;

class Solution2548 {
    public double maxPrice(int[][] items, int capacity) {
        Arrays.sort(items, (a, b) -> a[1] * b[0] - a[0] * b[1]);
        double ans = 0;
        for (var e : items) {
            int p = e[0], w = e[1];
            int v = Math.min(w, capacity);
            ans += v * 1.0 / w * p;
            capacity -= v;
        }
        return capacity > 0 ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2548 _tcSol = new Solution2548();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "items = [[50,1],[10,8]], capacity = 5");
        try {
            int[][] items = new int[][]{new int[]{50, 1}, new int[]{10, 8}};
            int capacity = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPrice(items, capacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "55.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "items = [[100,30]], capacity = 50");
        try {
            int[][] items = new int[][]{new int[]{100, 30}};
            int capacity = 50;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPrice(items, capacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1.00000");
        System.out.println();
    }
}