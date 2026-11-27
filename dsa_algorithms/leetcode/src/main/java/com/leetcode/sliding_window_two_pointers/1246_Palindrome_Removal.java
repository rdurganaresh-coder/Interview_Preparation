package com.leetcode.sliding_window_two_pointers;

class Solution1246 {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            f[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (i + 1 == j) {
                    f[i][j] = arr[i] == arr[j] ? 1 : 2;
                } else {
                    int t = arr[i] == arr[j] ? f[i + 1][j - 1] : 1 << 30;
                    for (int k = i; k < j; ++k) {
                        t = Math.min(t, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = t;
                }
            }
        }
        return f[0][n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1246 _tcSol = new Solution1246();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,2]");
        try {
            int[] arr = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumMoves(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,3,4,1,5]");
        try {
            int[] arr = new int[]{1, 3, 4, 1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumMoves(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}