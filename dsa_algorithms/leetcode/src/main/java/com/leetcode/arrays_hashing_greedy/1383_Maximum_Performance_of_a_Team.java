package com.leetcode.arrays_hashing_greedy;

class Solution1383 {
    private static final int MOD = (int) 1e9 + 7;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] t = new int[n][2];
        for (int i = 0; i < n; ++i) {
            t[i] = new int[] {speed[i], efficiency[i]};
        }
        Arrays.sort(t, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long tot = 0;
        long ans = 0;
        for (var x : t) {
            int s = x[0], e = x[1];
            tot += s;
            ans = Math.max(ans, tot * e);
            q.offer(s);
            if (q.size() == k) {
                tot -= q.poll();
            }
        }
        return (int) (ans % MOD);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1383 _tcSol = new Solution1383();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2");
        try {
            int n = 6;
            int[] speed = new int[]{2, 10, 3, 1, 5, 8};
            int[] efficiency = new int[]{5, 4, 3, 9, 7, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPerformance(n, speed, efficiency, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "60");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3");
        try {
            int n = 6;
            int[] speed = new int[]{2, 10, 3, 1, 5, 8};
            int[] efficiency = new int[]{5, 4, 3, 9, 7, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPerformance(n, speed, efficiency, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "68");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4");
        try {
            int n = 6;
            int[] speed = new int[]{2, 10, 3, 1, 5, 8};
            int[] efficiency = new int[]{5, 4, 3, 9, 7, 2};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPerformance(n, speed, efficiency, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "72");
        System.out.println();
    }
}