package com.leetcode.graphs_shortest_path;

class Solution0656 {
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        int n = coins.length;
        List<Integer> ans = new ArrayList<>();
        if (coins[n - 1] == -1) {
            return ans;
        }
        int[] f = new int[n];
        final int inf = 1 << 30;
        Arrays.fill(f, inf);
        f[n - 1] = coins[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            if (coins[i] != -1) {
                for (int j = i + 1; j < Math.min(n, i + maxJump + 1); ++j) {
                    if (f[i] > f[j] + coins[i]) {
                        f[i] = f[j] + coins[i];
                    }
                }
            }
        }
        if (f[0] == inf) {
            return ans;
        }
        for (int i = 0, s = f[0]; i < n; ++i) {
            if (f[i] == s) {
                s -= coins[i];
                ans.add(i + 1);
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
        Solution0656 _tcSol = new Solution0656();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "coins = [1,2,4,-1,2], maxJump = 2");
        try {
            int[] coins = new int[]{1, 2, 4, -1, 2};
            int maxJump = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.cheapestJump(coins, maxJump)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "coins = [1,2,4,-1,2], maxJump = 1");
        try {
            int[] coins = new int[]{1, 2, 4, -1, 2};
            int maxJump = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.cheapestJump(coins, maxJump)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}