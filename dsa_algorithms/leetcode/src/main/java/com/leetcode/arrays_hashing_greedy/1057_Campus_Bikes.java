package com.leetcode.arrays_hashing_greedy;

class Solution1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length, m = bikes.length;
        int[][] arr = new int[m * n][3];
        for (int i = 0, k = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int dist
                    = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                arr[k++] = new int[] {dist, i, j};
            }
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });
        boolean[] vis1 = new boolean[n];
        boolean[] vis2 = new boolean[m];
        int[] ans = new int[n];
        for (var e : arr) {
            int i = e[1], j = e[2];
            if (!vis1[i] && !vis2[j]) {
                vis1[i] = true;
                vis2[j] = true;
                ans[i] = j;
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
        Solution1057 _tcSol = new Solution1057();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]");
        try {
            int[][] workers = new int[][]{new int[]{0, 0}, new int[]{2, 1}};
            int[][] bikes = new int[][]{new int[]{1, 2}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.assignBikes(workers, bikes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]");
        try {
            int[][] workers = new int[][]{new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 0}};
            int[][] bikes = new int[][]{new int[]{1, 0}, new int[]{2, 2}, new int[]{2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.assignBikes(workers, bikes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2,1]");
        System.out.println();
    }
}