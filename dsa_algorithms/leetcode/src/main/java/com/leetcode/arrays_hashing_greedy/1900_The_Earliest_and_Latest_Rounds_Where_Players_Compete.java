package com.leetcode.arrays_hashing_greedy;

class Solution1900 {
    static int[][][] f = new int[30][30][31];

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        return dfs(firstPlayer - 1, secondPlayer - 1, n);
    }

    private int[] dfs(int l, int r, int n) {
        if (f[l][r][n] != 0) {
            return decode(f[l][r][n]);
        }
        if (l + r == n - 1) {
            f[l][r][n] = encode(1, 1);
            return new int[] {1, 1};
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int m = n >> 1;
        for (int i = 0; i < (1 << m); i++) {
            boolean[] win = new boolean[n];
            for (int j = 0; j < m; j++) {
                if (((i >> j) & 1) == 1) {
                    win[j] = true;
                } else {
                    win[n - 1 - j] = true;
                }
            }
            if ((n & 1) == 1) {
                win[m] = true;
            }
            win[n - 1 - l] = win[n - 1 - r] = false;
            win[l] = win[r] = true;
            int a = 0, b = 0, c = 0;
            for (int j = 0; j < n; j++) {
                if (j == l) {
                    a = c;
                }
                if (j == r) {
                    b = c;
                }
                if (win[j]) {
                    c++;
                }
            }
            int[] t = dfs(a, b, c);
            min = Math.min(min, t[0] + 1);
            max = Math.max(max, t[1] + 1);
        }
        f[l][r][n] = encode(min, max);
        return new int[] {min, max};
    }

    private int encode(int x, int y) {
        return (x << 8) | y;
    }

    private int[] decode(int val) {
        return new int[] {val >> 8, val & 255};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1900 _tcSol = new Solution1900();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 11, firstPlayer = 2, secondPlayer = 4");
        try {
            int n = 11;
            int firstPlayer = 2;
            int secondPlayer = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.earliestAndLatest(n, firstPlayer, secondPlayer)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, firstPlayer = 1, secondPlayer = 5");
        try {
            int n = 5;
            int firstPlayer = 1;
            int secondPlayer = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.earliestAndLatest(n, firstPlayer, secondPlayer)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1]");
        System.out.println();
    }
}
