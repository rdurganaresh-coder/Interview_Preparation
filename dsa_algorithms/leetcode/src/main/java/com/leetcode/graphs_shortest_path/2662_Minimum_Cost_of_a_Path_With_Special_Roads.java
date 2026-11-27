package com.leetcode.graphs_shortest_path;

class Solution2662 {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int ans = 1 << 30;
        int n = 1000000;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<Long> vis = new HashSet<>();
        q.offer(new int[] {0, start[0], start[1]});
        while (!q.isEmpty()) {
            var p = q.poll();
            int x = p[1], y = p[2];
            long k = 1L * x * n + y;
            if (vis.contains(k)) {
                continue;
            }
            vis.add(k);
            int d = p[0];
            ans = Math.min(ans, d + dist(x, y, target[0], target[1]));
            for (var r : specialRoads) {
                int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3], cost = r[4];
                q.offer(new int[] {d + dist(x, y, x1, y1) + cost, x2, y2});
            }
        }
        return ans;
    }

    private int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2662 _tcSol = new Solution2662();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "start = [1,1], target = [4,5], specialRoads = [[1,2,3,3,2],[3,4,4,5,1]]");
        try {
            int[] start = new int[]{1, 1};
            int[] target = new int[]{4, 5};
            int[][] specialRoads = new int[][]{new int[]{1, 2, 3, 3, 2}, new int[]{3, 4, 4, 5, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(start, target, specialRoads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "start = [3,2], target = [5,7], specialRoads = [[5,7,3,2,1],[3,2,3,4,4],[3,3,5,5,5],[3,4,5,6,6]]");
        try {
            int[] start = new int[]{3, 2};
            int[] target = new int[]{5, 7};
            int[][] specialRoads = new int[][]{new int[]{5, 7, 3, 2, 1}, new int[]{3, 2, 3, 4, 4}, new int[]{3, 3, 5, 5, 5}, new int[]{3, 4, 5, 6, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(start, target, specialRoads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "start = [1,1], target = [10,4], specialRoads = [[4,2,1,1,3],[1,2,7,4,4],[10,3,6,1,2],[6,1,1,2,3]]");
        try {
            int[] start = new int[]{1, 1};
            int[] target = new int[]{10, 4};
            int[][] specialRoads = new int[][]{new int[]{4, 2, 1, 1, 3}, new int[]{1, 2, 7, 4, 4}, new int[]{10, 3, 6, 1, 2}, new int[]{6, 1, 1, 2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(start, target, specialRoads)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}