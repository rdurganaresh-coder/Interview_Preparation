package com.leetcode.dynamic_programming;

class Solution1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : sticks) {
            pq.offer(x);
        }
        int ans = 0;
        while (pq.size() > 1) {
            int z = pq.poll() + pq.poll();
            ans += z;
            pq.offer(z);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1167 _tcSol = new Solution1167();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sticks = [2,4,3]");
        try {
            int[] sticks = new int[]{2, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.connectSticks(sticks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sticks = [1,8,3,5]");
        try {
            int[] sticks = new int[]{1, 8, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.connectSticks(sticks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "30");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "sticks = [5]");
        try {
            int[] sticks = new int[]{5};
            System.out.println("  Output  : " + _tcShow(_tcSol.connectSticks(sticks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}