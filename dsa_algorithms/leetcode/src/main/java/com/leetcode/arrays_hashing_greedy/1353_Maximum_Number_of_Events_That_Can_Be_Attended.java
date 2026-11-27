package com.leetcode.arrays_hashing_greedy;

class Solution1353 {
    public int maxEvents(int[][] events) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int l = Integer.MAX_VALUE, r = 0;
        for (int[] event : events) {
            int s = event[0], e = event[1];
            g.computeIfAbsent(s, k -> new ArrayList<>()).add(e);
            l = Math.min(l, s);
            r = Math.max(r, e);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        for (int s = l; s <= r; s++) {
            while (!pq.isEmpty() && pq.peek() < s) {
                pq.poll();
            }
            for (int e : g.getOrDefault(s, List.of())) {
                pq.offer(e);
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
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
        Solution1353 _tcSol = new Solution1353();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "events = [[1,2],[2,3],[3,4]]");
        try {
            int[][] events = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxEvents(events)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "events= [[1,2],[2,3],[3,4],[1,2]]");
        try {
            int[][] events = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxEvents(events)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
