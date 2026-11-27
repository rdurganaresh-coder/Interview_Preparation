package com.leetcode.sliding_window_two_pointers;

class Solution1798 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int ans = 1;
        for (int v : coins) {
            if (v > ans) {
                break;
            }
            ans += v;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1798 _tcSol = new Solution1798();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "coins = [1,3]");
        try {
            int[] coins = new int[]{1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaximumConsecutive(coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "coins = [1,1,1,4]");
        try {
            int[] coins = new int[]{1, 1, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaximumConsecutive(coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "coins = [1,4,10,3,1]");
        try {
            int[] coins = new int[]{1, 4, 10, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.getMaximumConsecutive(coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();
    }
}