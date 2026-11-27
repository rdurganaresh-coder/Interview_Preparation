package com.leetcode.matrices_grids;

class Solution2392 {
    private int k;

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        this.k = k;
        List<Integer> row = f(rowConditions);
        List<Integer> col = f(colConditions);
        if (row == null || col == null) {
            return new int[0][0];
        }
        int[][] ans = new int[k][k];
        int[] m = new int[k + 1];
        for (int i = 0; i < k; ++i) {
            m[col.get(i)] = i;
        }
        for (int i = 0; i < k; ++i) {
            ans[i][m[row.get(i)]] = row.get(i);
        }
        return ans;
    }

    private List<Integer> f(int[][] cond) {
        List<Integer>[] g = new List[k + 1];
        Arrays.setAll(g, key -> new ArrayList<>());
        int[] indeg = new int[k + 1];
        for (var e : cond) {
            int a = e[0], b = e[1];
            g[a].add(b);
            ++indeg[b];
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < indeg.length; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            for (int n = q.size(); n > 0; --n) {
                int i = q.pollFirst();
                res.add(i);
                for (int j : g[i]) {
                    if (--indeg[j] == 0) {
                        q.offer(j);
                    }
                }
            }
        }
        return res.size() == k ? res : null;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2392 _tcSol = new Solution2392();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 3, rowConditions = [[1,2],[3,2]], colConditions = [[2,1],[3,2]]");
        try {
            int k = 3;
            int[][] rowConditions = new int[][]{new int[]{1, 2}, new int[]{3, 2}};
            int[][] colConditions = new int[][]{new int[]{2, 1}, new int[]{3, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.buildMatrix(k, rowConditions, colConditions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,0,0],[0,0,1],[0,2,0]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 3, rowConditions = [[1,2],[2,3],[3,1],[2,3]], colConditions = [[2,1]]");
        try {
            int k = 3;
            int[][] rowConditions = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 1}, new int[]{2, 3}};
            int[][] colConditions = new int[][]{new int[]{2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.buildMatrix(k, rowConditions, colConditions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}