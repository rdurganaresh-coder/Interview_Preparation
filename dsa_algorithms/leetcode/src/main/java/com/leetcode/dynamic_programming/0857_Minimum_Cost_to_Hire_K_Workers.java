package com.leetcode.dynamic_programming;

class Solution0857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Pair<Double, Integer>[] t = new Pair[n];
        for (int i = 0; i < n; ++i) {
            t[i] = new Pair<>((double) wage[i] / quality[i], quality[i]);
        }
        Arrays.sort(t, (a, b) -> Double.compare(a.getKey(), b.getKey()));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        double ans = 1e18;
        int tot = 0;
        for (var e : t) {
            tot += e.getValue();
            pq.offer(e.getValue());
            if (pq.size() == k) {
                ans = Math.min(ans, tot * e.getKey());
                tot -= pq.poll();
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
        Solution0857 _tcSol = new Solution0857();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "quality = [10,20,5], wage = [70,50,30], k = 2");
        try {
            int[] quality = new int[]{10, 20, 5};
            int[] wage = new int[]{70, 50, 30};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.mincostToHireWorkers(quality, wage, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "105.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3");
        try {
            int[] quality = new int[]{3, 1, 10, 10, 1};
            int[] wage = new int[]{4, 8, 2, 2, 7};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.mincostToHireWorkers(quality, wage, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "30.66667");
        System.out.println();
    }
}
