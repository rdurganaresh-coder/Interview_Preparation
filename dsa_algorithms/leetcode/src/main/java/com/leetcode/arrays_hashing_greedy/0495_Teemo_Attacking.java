package com.leetcode.arrays_hashing_greedy;

class Solution0495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int ans = duration;
        for (int i = 1; i < n; ++i) {
            ans += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0495 _tcSol = new Solution0495();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "timeSeries = [1,4], duration = 2");
        try {
            int[] timeSeries = new int[]{1, 4};
            int duration = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findPoisonedDuration(timeSeries, duration)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "timeSeries = [1,2], duration = 2");
        try {
            int[] timeSeries = new int[]{1, 2};
            int duration = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findPoisonedDuration(timeSeries, duration)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}