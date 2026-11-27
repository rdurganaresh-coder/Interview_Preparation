package com.leetcode.arrays_hashing_greedy;

class Solution0887 {
    private int[][] f;

    public int superEggDrop(int k, int n) {
        f = new int[n + 1][k + 1];
        return dfs(n, k);
    }

    private int dfs(int i, int j) {
        if (i < 1) {
            return 0;
        }
        if (j == 1) {
            return i;
        }
        if (f[i][j] != 0) {
            return f[i][j];
        }
        int l = 1, r = i;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            int a = dfs(mid - 1, j - 1);
            int b = dfs(i - mid, j);
            if (a <= b) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return f[i][j] = Math.max(dfs(l - 1, j - 1), dfs(i - l, j)) + 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0887 _tcSol = new Solution0887();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 1, n = 2");
        try {
            int k = 1;
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.superEggDrop(k, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 2, n = 6");
        try {
            int k = 2;
            int n = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.superEggDrop(k, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "k = 3, n = 14");
        try {
            int k = 3;
            int n = 14;
            System.out.println("  Output  : " + _tcShow(_tcSol.superEggDrop(k, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}