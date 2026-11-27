package com.leetcode.arrays_hashing_greedy;

class Solution1504_2 {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] g = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 1) {
                    g[i][j] = j == 0 ? 1 : 1 + g[i][j - 1];
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            List<int[]> stk = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                int cur = g[i][j];
                while (!stk.isEmpty() && stk.get(stk.size() - 1)[0] >= cur) {
                    stk.remove(stk.size() - 1);
                }
                int cnt = cur * (i + 1);
                if (!stk.isEmpty()) {
                    int[] t = stk.get(stk.size() - 1);
                    cnt = t[2] + cur * (i - t[1]);
                }
                ans += cnt;
                stk.add(new int[] {cur, i, cnt});
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
        Solution1504_2 _tcSol = new Solution1504_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,0,1],[1,1,0],[1,1,0]]");
        try {
            int[][] mat = new int[][]{new int[]{1, 0, 1}, new int[]{1, 1, 0}, new int[]{1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubmat(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]");
        try {
            int[][] mat = new int[][]{new int[]{0, 1, 1, 0}, new int[]{0, 1, 1, 1}, new int[]{1, 1, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubmat(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();
    }
}
