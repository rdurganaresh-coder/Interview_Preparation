package com.leetcode.arrays_hashing_greedy;

class Solution1908 {
    private Map<Integer, Boolean> memo = new HashMap<>();
    private int[] p = new int[8];

    public Solution1908() {
        p[0] = 1;
        for (int i = 1; i < 8; ++i) {
            p[i] = p[i - 1] * 8;
        }
    }

    public boolean nimGame(int[] piles) {
        return dfs(piles);
    }

    private boolean dfs(int[] piles) {
        int st = f(piles);
        if (memo.containsKey(st)) {
            return memo.get(st);
        }
        for (int i = 0; i < piles.length; ++i) {
            for (int j = 1; j <= piles[i]; ++j) {
                piles[i] -= j;
                if (!dfs(piles)) {
                    piles[i] += j;
                    memo.put(st, true);
                    return true;
                }
                piles[i] += j;
            }
        }
        memo.put(st, false);
        return false;
    }

    private int f(int[] piles) {
        int st = 0;
        for (int i = 0; i < piles.length; ++i) {
            st += piles[i] * p[i];
        }
        return st;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1908 _tcSol = new Solution1908();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "piles = [1]");
        try {
            int[] piles = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.nimGame(piles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "piles = [1,1]");
        try {
            int[] piles = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.nimGame(piles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "piles = [1,2,3]");
        try {
            int[] piles = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.nimGame(piles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}