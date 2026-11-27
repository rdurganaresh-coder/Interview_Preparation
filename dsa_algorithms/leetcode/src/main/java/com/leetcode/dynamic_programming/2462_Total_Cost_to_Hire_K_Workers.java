package com.leetcode.dynamic_programming;

class Solution2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long ans = 0;
        if (candidates * 2 >= n) {
            Arrays.sort(costs);
            for (int i = 0; i < k; ++i) {
                ans += costs[i];
            }
            return ans;
        }
        PriorityQueue<int[]> pq
            = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < candidates; ++i) {
            pq.offer(new int[] {costs[i], i});
            pq.offer(new int[] {costs[n - i - 1], n - i - 1});
        }
        int l = candidates, r = n - candidates - 1;
        while (k-- > 0) {
            var p = pq.poll();
            ans += p[0];
            if (l > r) {
                continue;
            }
            if (p[1] < l) {
                pq.offer(new int[] {costs[l], l++});
            } else {
                pq.offer(new int[] {costs[r], r--});
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
        Solution2462 _tcSol = new Solution2462();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4");
        try {
            int[] costs = new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8};
            int k = 3;
            int candidates = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.totalCost(costs, k, candidates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "costs = [1,2,4,1], k = 3, candidates = 3");
        try {
            int[] costs = new int[]{1, 2, 4, 1};
            int k = 3;
            int candidates = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.totalCost(costs, k, candidates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}