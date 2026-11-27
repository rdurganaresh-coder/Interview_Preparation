package com.leetcode.arrays_hashing_greedy;

class Solution2768 {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        Map<Long, Integer> cnt = new HashMap<>(coordinates.length);
        int[] dirs = {0, 0, -1, -1, 0};
        for (var e : coordinates) {
            int x = e[0], y = e[1];
            for (int k = 0; k < 4; ++k) {
                int i = x + dirs[k], j = y + dirs[k + 1];
                if (i >= 0 && i < m - 1 && j >= 0 && j < n - 1) {
                    cnt.merge(1L * i * n + j, 1, Integer::sum);
                }
            }
        }
        long[] ans = new long[5];
        ans[0] = (m - 1L) * (n - 1);
        for (int x : cnt.values()) {
            ++ans[x];
            --ans[0];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2768 _tcSol = new Solution2768();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 3, n = 3, coordinates = [[0,0]]");
        try {
            int m = 3;
            int n = 3;
            int[][] coordinates = new int[][]{new int[]{0, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countBlackBlocks(m, n, coordinates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,1,0,0,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 3, n = 3, coordinates = [[0,0],[1,1],[0,2]]");
        try {
            int m = 3;
            int n = 3;
            int[][] coordinates = new int[][]{new int[]{0, 0}, new int[]{1, 1}, new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countBlackBlocks(m, n, coordinates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2,2,0,0]");
        System.out.println();
    }
}