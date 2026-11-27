package com.leetcode.arrays_hashing_greedy;

class Solution3476 {
    public long maxProfit(int[] workers, int[][] tasks) {
        Map<Integer, PriorityQueue<Integer>> d = new HashMap<>();
        for (var t : tasks) {
            int skill = t[0], profit = t[1];
            d.computeIfAbsent(skill, k -> new PriorityQueue<>((a, b) -> b - a)).offer(profit);
        }
        long ans = 0;
        for (int skill : workers) {
            if (d.containsKey(skill)) {
                var pq = d.get(skill);
                ans += pq.poll();
                if (pq.isEmpty()) {
                    d.remove(skill);
                }
            }
        }
        int mx = 0;
        for (var pq : d.values()) {
            mx = Math.max(mx, pq.peek());
        }
        ans += mx;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3476 _tcSol = new Solution3476();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "workers = [1,2,3,4,5], tasks = [[1,100],[2,400],[3,100],[3,400]]");
        try {
            int[] workers = new int[]{1, 2, 3, 4, 5};
            int[][] tasks = new int[][]{new int[]{1, 100}, new int[]{2, 400}, new int[]{3, 100}, new int[]{3, 400}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(workers, tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "workers = [10,10000,100000000], tasks = [[1,100]]");
        try {
            int[] workers = new int[]{10, 10000, 100000000};
            int[][] tasks = new int[][]{new int[]{1, 100}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(workers, tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "100");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "workers = [7], tasks = [[3,3],[3,3]]");
        try {
            int[] workers = new int[]{7};
            int[][] tasks = new int[][]{new int[]{3, 3}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfit(workers, tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
