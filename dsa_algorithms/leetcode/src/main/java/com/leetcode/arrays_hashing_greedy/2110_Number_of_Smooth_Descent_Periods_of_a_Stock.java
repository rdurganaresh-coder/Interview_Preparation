package com.leetcode.arrays_hashing_greedy;

class Solution2110 {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int n = prices.length;
        for (int i = 0, j = 0; i < n; i = j) {
            j = i + 1;
            while (j < n && prices[j - 1] - prices[j] == 1) {
                ++j;
            }
            int cnt = j - i;
            ans += (1L + cnt) * cnt / 2;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2110 _tcSol = new Solution2110();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [3,2,1,4]");
        try {
            int[] prices = new int[]{3, 2, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.getDescentPeriods(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prices = [8,6,7,7]");
        try {
            int[] prices = new int[]{8, 6, 7, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.getDescentPeriods(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "prices = [1]");
        try {
            int[] prices = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.getDescentPeriods(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}