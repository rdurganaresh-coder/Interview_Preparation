package com.leetcode.graphs_shortest_path;

class Solution0630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int s = 0;
        for (var e : courses) {
            int duration = e[0], last = e[1];
            pq.offer(duration);
            s += duration;
            while (s > last) {
                s -= pq.poll();
            }
        }
        return pq.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0630 _tcSol = new Solution0630();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]");
        try {
            int[][] courses = new int[][]{new int[]{100, 200}, new int[]{200, 1300}, new int[]{1000, 1250}, new int[]{2000, 3200}};
            System.out.println("  Output  : " + _tcShow(_tcSol.scheduleCourse(courses)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "courses = [[1,2]]");
        try {
            int[][] courses = new int[][]{new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.scheduleCourse(courses)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "courses = [[3,2],[4,3]]");
        try {
            int[][] courses = new int[][]{new int[]{3, 2}, new int[]{4, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.scheduleCourse(courses)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}