package com.leetcode.arrays_hashing_greedy;

class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int x : stones) {
            q.offer(x);
        }
        while (q.size() > 1) {
            int y = q.poll();
            int x = q.poll();
            if (x != y) {
                q.offer(y - x);
            }
        }
        return q.isEmpty() ? 0 : q.poll();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1046 _tcSol = new Solution1046();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stones = [2,7,4,1,8,1]");
        try {
            int[] stones = new int[]{2, 7, 4, 1, 8, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.lastStoneWeight(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stones = [1]");
        try {
            int[] stones = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.lastStoneWeight(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}