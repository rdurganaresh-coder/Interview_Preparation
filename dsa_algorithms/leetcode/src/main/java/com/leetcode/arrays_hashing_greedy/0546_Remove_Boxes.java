package com.leetcode.arrays_hashing_greedy;

class Solution0546 {
    private int[][][] f;
    private int[] b;

    public int removeBoxes(int[] boxes) {
        b = boxes;
        int n = b.length;
        f = new int[n][n][n];
        return dfs(0, n - 1, 0);
    }

    private int dfs(int i, int j, int k) {
        if (i > j) {
            return 0;
        }
        while (i < j && b[j] == b[j - 1]) {
            --j;
            ++k;
        }
        if (f[i][j][k] > 0) {
            return f[i][j][k];
        }
        int ans = dfs(i, j - 1, 0) + (k + 1) * (k + 1);
        for (int h = i; h < j; ++h) {
            if (b[h] == b[j]) {
                ans = Math.max(ans, dfs(h + 1, j - 1, 0) + dfs(i, h, k + 1));
            }
        }
        f[i][j][k] = ans;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0546 _tcSol = new Solution0546();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "boxes = [1,3,2,2,2,3,4,3,1]");
        try {
            int[] boxes = new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeBoxes(boxes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "23");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "boxes = [1,1,1]");
        try {
            int[] boxes = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeBoxes(boxes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "boxes = [1]");
        try {
            int[] boxes = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeBoxes(boxes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}