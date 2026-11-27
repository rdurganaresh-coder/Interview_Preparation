package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree2940 {
    private final int inf = 1 << 30;
    private int n;
    private int[] c;

    public BinaryIndexedTree2940(int n) {
        this.n = n;
        c = new int[n + 1];
        Arrays.fill(c, inf);
    }

    public void update(int x, int v) {
        while (x <= n) {
            c[x] = Math.min(c[x], v);
            x += x & -x;
        }
    }

    public int query(int x) {
        int mi = inf;
        while (x > 0) {
            mi = Math.min(mi, c[x]);
            x -= x & -x;
        }
        return mi == inf ? -1 : mi;
    }
}

class Solution2940 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int m = queries.length;
        for (int i = 0; i < m; ++i) {
            if (queries[i][0] > queries[i][1]) {
                queries[i] = new int[] {queries[i][1], queries[i][0]};
            }
        }
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; ++i) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> queries[j][1] - queries[i][1]);
        int[] s = heights.clone();
        Arrays.sort(s);
        int[] ans = new int[m];
        int j = n - 1;
        BinaryIndexedTree2940 tree = new BinaryIndexedTree2940(n);
        for (int i : idx) {
            int l = queries[i][0], r = queries[i][1];
            while (j > r) {
                int k = n - Arrays.binarySearch(s, heights[j]) + 1;
                tree.update(k, j);
                --j;
            }
            if (l == r || heights[l] < heights[r]) {
                ans[i] = r;
            } else {
                int k = n - Arrays.binarySearch(s, heights[l]);
                ans[i] = tree.query(k);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2940 _tcSol = new Solution2940();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "heights = [6,4,8,5,2,7], queries = [[0,1],[0,3],[2,4],[3,4],[2,2]]");
        try {
            int[] heights = new int[]{6, 4, 8, 5, 2, 7};
            int[][] queries = new int[][]{new int[]{0, 1}, new int[]{0, 3}, new int[]{2, 4}, new int[]{3, 4}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.leftmostBuildingQueries(heights, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,5,-1,5,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "heights = [5,3,8,2,6,1,4,6], queries = [[0,7],[3,5],[5,2],[3,0],[1,6]]");
        try {
            int[] heights = new int[]{5, 3, 8, 2, 6, 1, 4, 6};
            int[][] queries = new int[][]{new int[]{0, 7}, new int[]{3, 5}, new int[]{5, 2}, new int[]{3, 0}, new int[]{1, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.leftmostBuildingQueries(heights, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[7,6,-1,4,6]");
        System.out.println();
    }
}