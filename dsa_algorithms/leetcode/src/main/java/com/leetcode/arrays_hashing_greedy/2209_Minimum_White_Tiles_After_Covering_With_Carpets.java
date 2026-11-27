package com.leetcode.arrays_hashing_greedy;

class Solution2209 {
    private Integer[][] f;
    private int[] s;
    private int n;
    private int k;

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        n = floor.length();
        f = new Integer[n][numCarpets + 1];
        s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + (floor.charAt(i) == '1' ? 1 : 0);
        }
        k = carpetLen;
        return dfs(0, numCarpets);
    }

    private int dfs(int i, int j) {
        if (i >= n) {
            return 0;
        }
        if (j == 0) {
            return s[n] - s[i];
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        if (s[i + 1] == s[i]) {
            return dfs(i + 1, j);
        }
        int ans = Math.min(1 + dfs(i + 1, j), dfs(i + k, j - 1));
        f[i][j] = ans;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2209 _tcSol = new Solution2209();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "floor = \"10110101\", numCarpets = 2, carpetLen = 2");
        try {
            String floor = "10110101";
            int numCarpets = 2;
            int carpetLen = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumWhiteTiles(floor, numCarpets, carpetLen)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "floor = \"11111\", numCarpets = 2, carpetLen = 3");
        try {
            String floor = "11111";
            int numCarpets = 2;
            int carpetLen = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumWhiteTiles(floor, numCarpets, carpetLen)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
