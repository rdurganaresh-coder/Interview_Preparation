package com.leetcode.arrays_hashing_greedy;

class Solution2747 {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        int m = queries.length;
        int[][] qs = new int[m][0];
        for (int i = 0; i < m; ++i) {
            qs[i] = new int[] {queries[i], i};
        }
        Arrays.sort(qs, (a, b) -> a[0] - b[0]);
        Map<Integer, Integer> cnt = new HashMap<>();
        int[] ans = new int[m];
        int j = 0, k = 0;
        for (var q : qs) {
            int r = q[0], i = q[1];
            int l = r - x;
            while (k < logs.length && logs[k][1] <= r) {
                cnt.merge(logs[k++][0], 1, Integer::sum);
            }
            while (j < logs.length && logs[j][1] < l) {
                if (cnt.merge(logs[j][0], -1, Integer::sum) == 0) {
                    cnt.remove(logs[j][0]);
                }
                j++;
            }
            ans[i] = n - cnt.size();
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2747 _tcSol = new Solution2747();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, logs = [[1,3],[2,6],[1,5]], x = 5, queries = [10,11]");
        try {
            int n = 3;
            int[][] logs = new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{1, 5}};
            int x = 5;
            int[] queries = new int[]{10, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.countServers(n, logs, x, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, logs = [[2,4],[2,1],[1,2],[3,1]], x = 2, queries = [3,4]");
        try {
            int n = 3;
            int[][] logs = new int[][]{new int[]{2, 4}, new int[]{2, 1}, new int[]{1, 2}, new int[]{3, 1}};
            int x = 2;
            int[] queries = new int[]{3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.countServers(n, logs, x, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();
    }
}