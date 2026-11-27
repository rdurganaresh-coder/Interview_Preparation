package com.leetcode.arrays_hashing_greedy;

class Solution2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int n = items.length;
        int m = queries.length;
        int[] ans = new int[m];
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; ++i) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> queries[i] - queries[j]);
        int i = 0, mx = 0;
        for (int j : idx) {
            while (i < n && items[i][0] <= queries[j]) {
                mx = Math.max(mx, items[i][1]);
                ++i;
            }
            ans[j] = mx;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2070 _tcSol = new Solution2070();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]");
        try {
            int[][] items = new int[][]{new int[]{1, 2}, new int[]{3, 2}, new int[]{2, 4}, new int[]{5, 6}, new int[]{3, 5}};
            int[] queries = new int[]{1, 2, 3, 4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBeauty(items, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,4,5,5,6,6]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "items = [[1,2],[1,2],[1,3],[1,4]], queries = [1]");
        try {
            int[][] items = new int[][]{new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 4}};
            int[] queries = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBeauty(items, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "items = [[10,1000]], queries = [5]");
        try {
            int[][] items = new int[][]{new int[]{10, 1000}};
            int[] queries = new int[]{5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBeauty(items, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();
    }
}