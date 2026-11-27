package com.leetcode.arrays_hashing_greedy;

class Solution1475 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            int x = prices[i];
            while (!stk.isEmpty() && stk.peek() > x) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                prices[i] -= stk.peek();
            }
            stk.push(x);
        }
        return prices;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1475 _tcSol = new Solution1475();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "prices = [8,4,6,2,3]");
        try {
            int[] prices = new int[]{8, 4, 6, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.finalPrices(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,2,4,2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "prices = [1,2,3,4,5]");
        try {
            int[] prices = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.finalPrices(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,4,5]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "prices = [10,1,1,6]");
        try {
            int[] prices = new int[]{10, 1, 1, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.finalPrices(prices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,0,1,6]");
        System.out.println();
    }
}
