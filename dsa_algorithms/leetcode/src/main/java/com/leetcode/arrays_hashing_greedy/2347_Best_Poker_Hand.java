package com.leetcode.arrays_hashing_greedy;

class Solution2347 {
    public String bestHand(int[] ranks, char[] suits) {
        boolean flush = true;
        for (int i = 1; i < 5 && flush; ++i) {
            flush = suits[i] == suits[i - 1];
        }
        if (flush) {
            return "Flush";
        }
        int[] cnt = new int[14];
        boolean pair = false;
        for (int x : ranks) {
            if (++cnt[x] == 3) {
                return "Three of a Kind";
            }
            pair = pair || cnt[x] == 2;
        }
        return pair ? "Pair" : "High Card";
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2347 _tcSol = new Solution2347();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "ranks = [13,2,3,1,9], suits = [\"a\",\"a\",\"a\",\"a\",\"a\"]");
        try {
            int[] ranks = new int[]{13, 2, 3, 1, 9};
            char[] suits = new char[]{'a', 'a', 'a', 'a', 'a'};
            System.out.println("  Output  : " + _tcShow(_tcSol.bestHand(ranks, suits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Flush\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "ranks = [4,4,2,4,4], suits = [\"d\",\"a\",\"a\",\"b\",\"c\"]");
        try {
            int[] ranks = new int[]{4, 4, 2, 4, 4};
            char[] suits = new char[]{'d', 'a', 'a', 'b', 'c'};
            System.out.println("  Output  : " + _tcShow(_tcSol.bestHand(ranks, suits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Three of a Kind\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "ranks = [10,10,2,12,9], suits = [\"a\",\"b\",\"c\",\"a\",\"d\"]");
        try {
            int[] ranks = new int[]{10, 10, 2, 12, 9};
            char[] suits = new char[]{'a', 'b', 'c', 'a', 'd'};
            System.out.println("  Output  : " + _tcShow(_tcSol.bestHand(ranks, suits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Pair\"");
        System.out.println();
    }
}