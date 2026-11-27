package com.leetcode.arrays_hashing_greedy;

class Solution1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = -(1 << 30);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (var p : points) {
            int x = p[0], y = p[1];
            while (!pq.isEmpty() && x - pq.peek()[1] > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans = Math.max(ans, x + y + pq.peek()[0]);
            }
            pq.offer(new int[] {y - x, x});
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1499 _tcSol = new Solution1499();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[1,3],[2,0],[5,10],[6,-10]], k = 1");
        try {
            int[][] points = new int[][]{new int[]{1, 3}, new int[]{2, 0}, new int[]{5, 10}, new int[]{6, -10}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxValueOfEquation(points, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[0,0],[3,0],[9,2]], k = 3");
        try {
            int[][] points = new int[][]{new int[]{0, 0}, new int[]{3, 0}, new int[]{9, 2}};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxValueOfEquation(points, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}