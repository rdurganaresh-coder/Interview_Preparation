package com.leetcode.arrays_hashing_greedy;

class Solution1751 {
    private int[][] events;
    private int[][] f;
    private int n;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        this.events = events;
        n = events.length;
        f = new int[n][k + 1];
        return dfs(0, k);
    }

    private int dfs(int i, int k) {
        if (i >= n || k <= 0) {
            return 0;
        }
        if (f[i][k] != 0) {
            return f[i][k];
        }
        int j = search(events, events[i][1], i + 1);
        int ans = Math.max(dfs(i + 1, k), dfs(j, k - 1) + events[i][2]);
        return f[i][k] = ans;
    }

    private int search(int[][] events, int x, int lo) {
        int l = lo, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (events[mid][0] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1751 _tcSol = new Solution1751();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "events = [[1,2,4],[3,4,3],[2,3,1]], k = 2");
        try {
            int[][] events = new int[][]{new int[]{1, 2, 4}, new int[]{3, 4, 3}, new int[]{2, 3, 1}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxValue(events, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "events = [[1,2,4],[3,4,3],[2,3,10]], k = 2");
        try {
            int[][] events = new int[][]{new int[]{1, 2, 4}, new int[]{3, 4, 3}, new int[]{2, 3, 10}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxValue(events, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "events = [[1,1,1],[2,2,2],[3,3,3],[4,4,4]], k = 3");
        try {
            int[][] events = new int[][]{new int[]{1, 1, 1}, new int[]{2, 2, 2}, new int[]{3, 3, 3}, new int[]{4, 4, 4}};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxValue(events, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}
