package com.leetcode.arrays_hashing_greedy;

class Solution0403 {
    private Boolean[][] f;
    private Map<Integer, Integer> pos = new HashMap<>();
    private int[] stones;
    private int n;

    public boolean canCross(int[] stones) {
        n = stones.length;
        f = new Boolean[n][n];
        this.stones = stones;
        for (int i = 0; i < n; ++i) {
            pos.put(stones[i], i);
        }
        return dfs(0, 0);
    }

    private boolean dfs(int i, int k) {
        if (i == n - 1) {
            return true;
        }
        if (f[i][k] != null) {
            return f[i][k];
        }
        for (int j = k - 1; j <= k + 1; ++j) {
            if (j > 0) {
                int h = stones[i] + j;
                if (pos.containsKey(h) && dfs(pos.get(h), j)) {
                    return f[i][k] = true;
                }
            }
        }
        return f[i][k] = false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0403 _tcSol = new Solution0403();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stones = [0,1,3,5,6,8,12,17]");
        try {
            int[] stones = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
            System.out.println("  Output  : " + _tcShow(_tcSol.canCross(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stones = [0,1,2,3,4,8,9,11]");
        try {
            int[] stones = new int[]{0, 1, 2, 3, 4, 8, 9, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.canCross(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}