package com.leetcode.arrays_hashing_greedy;

class Solution3506 {
    public long minEliminationTime(int[] timeReq, int splitTime) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int x : timeReq) {
            q.offer((long) x);
        }
        while (q.size() > 1) {
            q.poll();
            q.offer(q.poll() + splitTime);
        }
        return q.poll();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3506 _tcSol = new Solution3506();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "timeReq = [10,4,5], splitTime = 2");
        try {
            int[] timeReq = new int[]{10, 4, 5};
            int splitTime = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minEliminationTime(timeReq, splitTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "timeReq = [10,4], splitTime = 5");
        try {
            int[] timeReq = new int[]{10, 4};
            int splitTime = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minEliminationTime(timeReq, splitTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}