package com.leetcode.arrays_hashing_greedy;

class Solution1354 {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long s = 0;
        for (int x : target) {
            s += x;
            pq.offer((long) x);
        }
        while (pq.peek() > 1) {
            long mx = pq.poll();
            long t = s - mx;
            if (t == 0 || mx - t < 1) {
                return false;
            }
            long x = mx % t;
            if (x == 0) {
                x = t;
            }
            pq.offer(x);
            s = s - mx + x;
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1354 _tcSol = new Solution1354();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = [9,3,5]");
        try {
            int[] target = new int[]{9, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossible(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = [1,1,1,2]");
        try {
            int[] target = new int[]{1, 1, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossible(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "target = [8,5]");
        try {
            int[] target = new int[]{8, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossible(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}