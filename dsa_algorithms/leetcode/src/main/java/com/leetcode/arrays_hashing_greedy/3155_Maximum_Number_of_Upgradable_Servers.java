package com.leetcode.arrays_hashing_greedy;

class Solution3155 {
    public int[] maxUpgrades(int[] count, int[] upgrade, int[] sell, int[] money) {
        int n = count.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = Math.min(
                count[i], (int) ((1L * count[i] * sell[i] + money[i]) / (upgrade[i] + sell[i])));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3155 _tcSol = new Solution3155();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "count = [4,3], upgrade = [3,5], sell = [4,2], money = [8,9]");
        try {
            int[] count = new int[]{4, 3};
            int[] upgrade = new int[]{3, 5};
            int[] sell = new int[]{4, 2};
            int[] money = new int[]{8, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxUpgrades(count, upgrade, sell, money)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "count = [1], upgrade = [2], sell = [1], money = [1]");
        try {
            int[] count = new int[]{1};
            int[] upgrade = new int[]{2};
            int[] sell = new int[]{1};
            int[] money = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxUpgrades(count, upgrade, sell, money)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();
    }
}