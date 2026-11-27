package com.leetcode.matrices_grids;

class Solution2718 {
    public long matrixSumQueries(int n, int[][] queries) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        int m = queries.length;
        long ans = 0;
        for (int k = m - 1; k >= 0; --k) {
            var q = queries[k];
            int t = q[0], i = q[1], v = q[2];
            if (t == 0) {
                if (row.add(i)) {
                    ans += 1L * (n - col.size()) * v;
                }
            } else {
                if (col.add(i)) {
                    ans += 1L * (n - row.size()) * v;
                }
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
        Solution2718 _tcSol = new Solution2718();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, queries = [[0,0,1],[1,2,2],[0,2,3],[1,0,4]]");
        try {
            int n = 3;
            int[][] queries = new int[][]{new int[]{0, 0, 1}, new int[]{1, 2, 2}, new int[]{0, 2, 3}, new int[]{1, 0, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixSumQueries(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "23");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, queries = [[0,0,4],[0,1,2],[1,0,1],[0,2,3],[1,2,1]]");
        try {
            int n = 3;
            int[][] queries = new int[][]{new int[]{0, 0, 4}, new int[]{0, 1, 2}, new int[]{1, 0, 1}, new int[]{0, 2, 3}, new int[]{1, 2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.matrixSumQueries(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();
    }
}