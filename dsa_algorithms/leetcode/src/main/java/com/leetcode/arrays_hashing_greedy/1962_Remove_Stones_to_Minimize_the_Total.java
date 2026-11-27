package com.leetcode.arrays_hashing_greedy;

class Solution1962 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : piles) {
            pq.offer(x);
        }
        while (k-- > 0) {
            int x = pq.poll();
            pq.offer(x - x / 2);
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1962 _tcSol = new Solution1962();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "piles = [5,4,9], k = 2");
        try {
            int[] piles = new int[]{5, 4, 9};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minStoneSum(piles, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "piles = [4,3,6,7], k = 3");
        try {
            int[] piles = new int[]{4, 3, 6, 7};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minStoneSum(piles, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}