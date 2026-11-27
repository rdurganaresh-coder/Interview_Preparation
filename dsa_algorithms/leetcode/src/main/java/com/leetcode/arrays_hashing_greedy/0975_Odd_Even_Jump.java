package com.leetcode.arrays_hashing_greedy;

class Solution0975 {
    private int n;
    private Integer[][] f;
    private int[][] g;

    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        n = arr.length;
        f = new Integer[n][2];
        g = new int[n][2];
        for (int i = n - 1; i >= 0; --i) {
            var hi = tm.ceilingEntry(arr[i]);
            g[i][1] = hi == null ? -1 : hi.getValue();
            var lo = tm.floorEntry(arr[i]);
            g[i][0] = lo == null ? -1 : lo.getValue();
            tm.put(arr[i], i);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += dfs(i, 1);
        }
        return ans;
    }

    private int dfs(int i, int k) {
        if (i == n - 1) {
            return 1;
        }
        if (g[i][k] == -1) {
            return 0;
        }
        if (f[i][k] != null) {
            return f[i][k];
        }
        return f[i][k] = dfs(g[i][k], k ^ 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0975 _tcSol = new Solution0975();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [10,13,12,14,15]");
        try {
            int[] arr = new int[]{10, 13, 12, 14, 15};
            System.out.println("  Output  : " + _tcShow(_tcSol.oddEvenJumps(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [2,3,1,1,4]");
        try {
            int[] arr = new int[]{2, 3, 1, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.oddEvenJumps(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [5,1,3,4,2]");
        try {
            int[] arr = new int[]{5, 1, 3, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.oddEvenJumps(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
