package com.leetcode.arrays_hashing_greedy;

class Solution0871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = stations.length;
        int ans = 0, pre = 0;
        for (int i = 0; i <= n; ++i) {
            int pos = i < n ? stations[i][0] : target;
            int dist = pos - pre;
            startFuel -= dist;
            while (startFuel < 0 && !pq.isEmpty()) {
                startFuel += pq.poll();
                ++ans;
            }
            if (startFuel < 0) {
                return -1;
            }
            if (i < n) {
                pq.offer(stations[i][1]);
                pre = stations[i][0];
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0871 _tcSol = new Solution0871();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = 1, startFuel = 1, stations = []");
        try {
            int target = 1;
            int startFuel = 1;
            int[][] stations = new int[][]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.minRefuelStops(target, startFuel, stations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = 100, startFuel = 1, stations = [[10,100]]");
        try {
            int target = 100;
            int startFuel = 1;
            int[][] stations = new int[][]{new int[]{10, 100}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minRefuelStops(target, startFuel, stations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]");
        try {
            int target = 100;
            int startFuel = 10;
            int[][] stations = new int[][]{new int[]{10, 60}, new int[]{20, 30}, new int[]{30, 30}, new int[]{60, 40}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minRefuelStops(target, startFuel, stations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
