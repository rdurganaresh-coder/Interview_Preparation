package com.leetcode.arrays_hashing_greedy;

class Solution2398 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = chargeTimes.length;
        int ans = 0;
        long s = 0;
        for (int l = 0, r = 0; r < n; ++r) {
            s += runningCosts[r];
            while (!q.isEmpty() && chargeTimes[q.peekLast()] <= chargeTimes[r]) {
                q.pollLast();
            }
            q.offerLast(r);
            while (!q.isEmpty() && (r - l + 1) * s + chargeTimes[q.peekFirst()] > budget) {
                if (q.peekFirst() == l) {
                    q.pollFirst();
                }
                s -= runningCosts[l++];
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2398 _tcSol = new Solution2398();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "chargeTimes = [3,6,1,3,4], runningCosts = [2,1,3,4,5], budget = 25");
        try {
            int[] chargeTimes = new int[]{3, 6, 1, 3, 4};
            int[] runningCosts = new int[]{2, 1, 3, 4, 5};
            long budget = 25L;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumRobots(chargeTimes, runningCosts, budget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "chargeTimes = [11,12,19], runningCosts = [10,8,7], budget = 19");
        try {
            int[] chargeTimes = new int[]{11, 12, 19};
            int[] runningCosts = new int[]{10, 8, 7};
            long budget = 19L;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumRobots(chargeTimes, runningCosts, budget)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
