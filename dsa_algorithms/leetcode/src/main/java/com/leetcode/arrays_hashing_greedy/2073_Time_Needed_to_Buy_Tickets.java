package com.leetcode.arrays_hashing_greedy;

class Solution2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        for (int i = 0; i < tickets.length; ++i) {
            ans += Math.min(tickets[i], i <= k ? tickets[k] : tickets[k] - 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2073 _tcSol = new Solution2073();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tickets = [2,3,2], k = 2");
        try {
            int[] tickets = new int[]{2, 3, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.timeRequiredToBuy(tickets, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tickets = [5,1,1,1], k = 0");
        try {
            int[] tickets = new int[]{5, 1, 1, 1};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.timeRequiredToBuy(tickets, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}