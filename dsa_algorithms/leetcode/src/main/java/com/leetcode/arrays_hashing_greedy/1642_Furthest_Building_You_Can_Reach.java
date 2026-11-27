package com.leetcode.arrays_hashing_greedy;

class Solution1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = heights.length;
        for (int i = 0; i < n - 1; ++i) {
            int a = heights[i], b = heights[i + 1];
            int d = b - a;
            if (d > 0) {
                q.offer(d);
                if (q.size() > ladders) {
                    bricks -= q.poll();
                    if (bricks < 0) {
                        return i;
                    }
                }
            }
        }
        return n - 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1642 _tcSol = new Solution1642();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1");
        try {
            int[] heights = new int[]{4, 2, 7, 6, 9, 14, 12};
            int bricks = 5;
            int ladders = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.furthestBuilding(heights, bricks, ladders)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2");
        try {
            int[] heights = new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19};
            int bricks = 10;
            int ladders = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.furthestBuilding(heights, bricks, ladders)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "heights = [14,3,19,3], bricks = 17, ladders = 0");
        try {
            int[] heights = new int[]{14, 3, 19, 3};
            int bricks = 17;
            int ladders = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.furthestBuilding(heights, bricks, ladders)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}