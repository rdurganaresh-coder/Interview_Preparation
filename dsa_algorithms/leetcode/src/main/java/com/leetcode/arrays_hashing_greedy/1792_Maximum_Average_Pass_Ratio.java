package com.leetcode.arrays_hashing_greedy;

class Solution1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> {
            double x = (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
            double y = (b[0] + 1) / (b[1] + 1) - b[0] / b[1];
            return Double.compare(y, x);
        });
        for (var e : classes) {
            pq.offer(new double[] {e[0], e[1]});
        }
        while (extraStudents-- > 0) {
            var e = pq.poll();
            double a = e[0] + 1, b = e[1] + 1;
            pq.offer(new double[] {a, b});
        }
        double ans = 0;
        while (!pq.isEmpty()) {
            var e = pq.poll();
            ans += e[0] / e[1];
        }
        return ans / classes.length;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1792 _tcSol = new Solution1792();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "classes = [[1,2],[3,5],[2,2]], extraStudents = 2");
        try {
            int[][] classes = new int[][]{new int[]{1, 2}, new int[]{3, 5}, new int[]{2, 2}};
            int extraStudents = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAverageRatio(classes, extraStudents)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.78333");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4");
        try {
            int[][] classes = new int[][]{new int[]{2, 4}, new int[]{3, 9}, new int[]{4, 5}, new int[]{2, 10}};
            int extraStudents = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAverageRatio(classes, extraStudents)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.53485");
        System.out.println();
    }
}