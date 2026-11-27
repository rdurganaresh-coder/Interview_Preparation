package com.leetcode.dynamic_programming;

class Solution2952 {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int ans = 0;
        for (int i = 0, s = 1; s <= target;) {
            if (i < coins.length && coins[i] <= s) {
                s += coins[i++];
            } else {
                s <<= 1;
                ++ans;
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
        Solution2952 _tcSol = new Solution2952();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "coins = [1,4,10], target = 19");
        try {
            int[] coins = new int[]{1, 4, 10};
            int target = 19;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumAddedCoins(coins, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "coins = [1,4,10,5,7,19], target = 19");
        try {
            int[] coins = new int[]{1, 4, 10, 5, 7, 19};
            int target = 19;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumAddedCoins(coins, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "coins = [1,1,1], target = 20");
        try {
            int[] coins = new int[]{1, 1, 1};
            int target = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumAddedCoins(coins, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}