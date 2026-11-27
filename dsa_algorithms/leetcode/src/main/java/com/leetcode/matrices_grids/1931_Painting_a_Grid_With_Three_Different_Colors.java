package com.leetcode.matrices_grids;

class Solution1931 {
    private int m;

    public int colorTheGrid(int m, int n) {
        this.m = m;
        final int mod = (int) 1e9 + 7;
        int mx = (int) Math.pow(3, m);
        Set<Integer> valid = new HashSet<>();
        int[] f = new int[mx];
        for (int i = 0; i < mx; ++i) {
            if (f1(i)) {
                valid.add(i);
                f[i] = 1;
            }
        }
        Map<Integer, List<Integer>> d = new HashMap<>();
        for (int i : valid) {
            for (int j : valid) {
                if (f2(i, j)) {
                    d.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        for (int k = 1; k < n; ++k) {
            int[] g = new int[mx];
            for (int i : valid) {
                for (int j : d.getOrDefault(i, List.of())) {
                    g[i] = (g[i] + f[j]) % mod;
                }
            }
            f = g;
        }
        int ans = 0;
        for (int x : f) {
            ans = (ans + x) % mod;
        }
        return ans;
    }

    private boolean f1(int x) {
        int last = -1;
        for (int i = 0; i < m; ++i) {
            if (x % 3 == last) {
                return false;
            }
            last = x % 3;
            x /= 3;
        }
        return true;
    }

    private boolean f2(int x, int y) {
        for (int i = 0; i < m; ++i) {
            if (x % 3 == y % 3) {
                return false;
            }
            x /= 3;
            y /= 3;
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1931 _tcSol = new Solution1931();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 1, n = 1");
        try {
            int m = 1;
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.colorTheGrid(m, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 1, n = 2");
        try {
            int m = 1;
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.colorTheGrid(m, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "m = 5, n = 5");
        try {
            int m = 5;
            int n = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.colorTheGrid(m, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "580986");
        System.out.println();
    }
}