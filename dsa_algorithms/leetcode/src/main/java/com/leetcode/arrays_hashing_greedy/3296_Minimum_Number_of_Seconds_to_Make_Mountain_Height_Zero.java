package com.leetcode.arrays_hashing_greedy;

class Solution3296 {
    private int mountainHeight;
    private int[] workerTimes;

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        this.mountainHeight = mountainHeight;
        this.workerTimes = workerTimes;
        long l = 1, r = (long) 1e16;
        while (l < r) {
            long mid = (l + r) >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(long t) {
        long h = 0;
        for (int wt : workerTimes) {
            h += (long) (Math.sqrt(t * 2.0 / wt + 0.25) - 0.5);
        }
        return h >= mountainHeight;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3296 _tcSol = new Solution3296();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mountainHeight = 4, workerTimes = [2,1,1]");
        try {
            int mountainHeight = 4;
            int[] workerTimes = new int[]{2, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumberOfSeconds(mountainHeight, workerTimes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mountainHeight = 10, workerTimes = [3,2,2,4]");
        try {
            int mountainHeight = 10;
            int[] workerTimes = new int[]{3, 2, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumberOfSeconds(mountainHeight, workerTimes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "mountainHeight = 5, workerTimes = [1]");
        try {
            int mountainHeight = 5;
            int[] workerTimes = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumberOfSeconds(mountainHeight, workerTimes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}
