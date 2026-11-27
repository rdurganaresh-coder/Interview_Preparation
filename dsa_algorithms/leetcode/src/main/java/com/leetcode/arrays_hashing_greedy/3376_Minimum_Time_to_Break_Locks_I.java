package com.leetcode.arrays_hashing_greedy;

class Solution3376 {
    private List<Integer> strength;
    private Integer[] f;
    private int k;
    private int n;

    public int findMinimumTime(List<Integer> strength, int K) {
        n = strength.size();
        f = new Integer[1 << n];
        k = K;
        this.strength = strength;
        return dfs(0);
    }

    private int dfs(int i) {
        if (i == (1 << n) - 1) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        int cnt = Integer.bitCount(i);
        int x = 1 + cnt * k;
        f[i] = 1 << 30;
        for (int j = 0; j < n; ++j) {
            if ((i >> j & 1) == 0) {
                f[i] = Math.min(f[i], dfs(i | 1 << j) + (strength.get(j) + x - 1) / x);
            }
        }
        return f[i];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution3376 _tcSol = new Solution3376();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "strength = [3,4,1], k = 1");
        try {
            List<Integer> strength = _tcL(3, 4, 1);
            int K = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinimumTime(strength, K)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "strength = [2,5,4], k = 2");
        try {
            List<Integer> strength = _tcL(2, 5, 4);
            int K = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinimumTime(strength, K)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
