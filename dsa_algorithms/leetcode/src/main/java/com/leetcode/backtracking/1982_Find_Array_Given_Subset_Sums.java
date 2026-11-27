package com.leetcode.backtracking;

class Solution1982 {
    public int[] recoverArray(int n, int[] sums) {
        int m = 1 << 30;
        for (int x : sums) {
            m = Math.min(m, x);
        }
        m = -m;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int x : sums) {
            tm.merge(x + m, 1, Integer::sum);
        }
        int[] ans = new int[n];
        if (tm.merge(0, -1, Integer::sum) == 0) {
            tm.remove(0);
        }
        ans[0] = tm.firstKey();
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 1 << i; ++j) {
                if ((j >> (i - 1) & 1) == 1) {
                    int s = 0;
                    for (int k = 0; k < i; ++k) {
                        if (((j >> k) & 1) == 1) {
                            s += ans[k];
                        }
                    }
                    if (tm.merge(s, -1, Integer::sum) == 0) {
                        tm.remove(s);
                    }
                }
            }
            ans[i] = tm.firstKey();
        }
        for (int i = 0; i < 1 << n; ++i) {
            int s = 0;
            for (int j = 0; j < n; ++j) {
                if (((i >> j) & 1) == 1) {
                    s += ans[j];
                }
            }
            if (s == m) {
                for (int j = 0; j < n; ++j) {
                    if (((i >> j) & 1) == 1) {
                        ans[j] *= -1;
                    }
                }
                break;
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
        Solution1982 _tcSol = new Solution1982();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, sums = [-3,-2,-1,0,0,1,2,3]");
        try {
            int n = 3;
            int[] sums = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.recoverArray(n, sums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,-3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, sums = [0,0,0,0]");
        try {
            int n = 2;
            int[] sums = new int[]{0, 0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.recoverArray(n, sums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, sums = [0,0,5,5,4,-1,4,9,9,-1,4,3,4,8,3,8]");
        try {
            int n = 4;
            int[] sums = new int[]{0, 0, 5, 5, 4, -1, 4, 9, 9, -1, 4, 3, 4, 8, 3, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.recoverArray(n, sums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,-1,4,5]");
        System.out.println();
    }
}