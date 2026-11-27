package com.leetcode.graphs_shortest_path;

class Solution0815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                g.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        if (!g.containsKey(source) || !g.containsKey(target)) {
            return -1;
        }

        Deque<int[]> q = new ArrayDeque<>();
        Set<Integer> visBus = new HashSet<>();
        Set<Integer> visStop = new HashSet<>();
        q.offer(new int[] {source, 0});
        visStop.add(source);

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int stop = current[0], busCount = current[1];

            if (stop == target) {
                return busCount;
            }
            for (int bus : g.get(stop)) {
                if (visBus.add(bus)) {
                    for (int nextStop : routes[bus]) {
                        if (visStop.add(nextStop)) {
                            q.offer(new int[] {nextStop, busCount + 1});
                        }
                    }
                }
            }
        }

        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0815 _tcSol = new Solution0815();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "routes = [[1,2,7],[3,6,7]], source = 1, target = 6");
        try {
            int[][] routes = new int[][]{new int[]{1, 2, 7}, new int[]{3, 6, 7}};
            int source = 1;
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.numBusesToDestination(routes, source, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12");
        try {
            int[][] routes = new int[][]{new int[]{7, 12}, new int[]{4, 5, 15}, new int[]{6}, new int[]{15, 19}, new int[]{9, 12, 13}};
            int source = 15;
            int target = 12;
            System.out.println("  Output  : " + _tcShow(_tcSol.numBusesToDestination(routes, source, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
