package com.leetcode.arrays_hashing_greedy;

class Solution1499_2 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = -(1 << 30);
        Deque<int[]> q = new ArrayDeque<>();
        for (var p : points) {
            int x = p[0], y = p[1];
            while (!q.isEmpty() && x - q.peekFirst()[0] > k) {
                q.pollFirst();
            }
            if (!q.isEmpty()) {
                ans = Math.max(ans, x + y + q.peekFirst()[1] - q.peekFirst()[0]);
            }
            while (!q.isEmpty() && y - x >= q.peekLast()[1] - q.peekLast()[0]) {
                q.pollLast();
            }
            q.offerLast(p);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1499_2 _tcSol = new Solution1499_2();
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