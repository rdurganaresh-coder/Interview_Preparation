package com.leetcode.arrays_hashing_greedy;

class Solution0950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> q = new ArrayDeque<>();
        Arrays.sort(deck);
        int n = deck.length;
        for (int i = n - 1; i >= 0; --i) {
            if (!q.isEmpty()) {
                q.offerFirst(q.pollLast());
            }
            q.offerFirst(deck[i]);
        }
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            ans[i] = q.pollLast();
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0950 _tcSol = new Solution0950();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "deck = [17,13,11,2,3,5,7]");
        try {
            int[] deck = new int[]{17, 13, 11, 2, 3, 5, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.deckRevealedIncreasing(deck)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,13,3,11,5,17,7]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "deck = [1,1000]");
        try {
            int[] deck = new int[]{1, 1000};
            System.out.println("  Output  : " + _tcShow(_tcSol.deckRevealedIncreasing(deck)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1000]");
        System.out.println();
    }
}