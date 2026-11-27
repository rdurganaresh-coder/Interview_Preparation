package com.leetcode.dynamic_programming;

class Solution2898 {
    public long maxScore(int[] prices) {
        Map<Integer, Long> cnt = new HashMap<>();
        for (int i = 0; i < prices.length; ++i) {
            cnt.merge(prices[i] - i, (long) prices[i], Long::sum);
        }
        long ans = 0;
        for (long v : cnt.values()) {
            ans = Math.max(ans, v);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2898 _tcSol = new Solution2898();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [1,5,3,7,8]");
        try {
            int[] prices = new int[]{1, 5, 3, 7, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prices = [5,6,7,8,9]");
        try {
            int[] prices = new int[]{5, 6, 7, 8, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "35");
        System.out.println();
    }
}