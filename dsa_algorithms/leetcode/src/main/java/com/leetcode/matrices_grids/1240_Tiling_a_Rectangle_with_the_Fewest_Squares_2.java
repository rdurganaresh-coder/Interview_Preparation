package com.leetcode.matrices_grids;

class Solution1240_2 {
    private int n;
    private int m;
    private int[] filled;
    private int ans;

    public int tilingRectangle(int n, int m) {
        this.n = n;
        this.m = m;
        ans = n * m;
        filled = new int[n];
        dfs(0, 0, 0);
        return ans;
    }

    private void dfs(int i, int j, int t) {
        if (j == m) {
            ++i;
            j = 0;
        }
        if (i == n) {
            ans = t;
            return;
        }
        if ((filled[i] >> j & 1) == 1) {
            dfs(i, j + 1, t);
        } else if (t + 1 < ans) {
            int r = 0, c = 0;
            for (int k = i; k < n; ++k) {
                if ((filled[k] >> j & 1) == 1) {
                    break;
                }
                ++r;
            }
            for (int k = j; k < m; ++k) {
                if ((filled[i] >> k & 1) == 1) {
                    break;
                }
                ++c;
            }
            int mx = Math.min(r, c);
            for (int x = i; x < i + mx; ++x) {
                for (int y = j; y < j + mx; ++y) {
                    filled[x] |= 1 << y;
                }
            }
            for (int w = mx; w > 0; --w) {
                dfs(i, j + w, t + 1);
                for (int k = 0; k < w; ++k) {
                    filled[i + w - 1] ^= 1 << (j + k);
                    if (k < w - 1) {
                        filled[i + k] ^= 1 << (j + w - 1);
                    }
                }
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1240_2 _tcSol = new Solution1240_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, m = 3");
        try {
            int n = 2;
            int m = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.tilingRectangle(n, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, m = 8");
        try {
            int n = 5;
            int m = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.tilingRectangle(n, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 11, m = 13");
        try {
            int n = 11;
            int m = 13;
            System.out.println("  Output  : " + _tcShow(_tcSol.tilingRectangle(n, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}