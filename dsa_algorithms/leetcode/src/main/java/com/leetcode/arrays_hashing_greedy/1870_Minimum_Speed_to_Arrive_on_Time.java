package com.leetcode.arrays_hashing_greedy;

class Solution1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length > Math.ceil(hour)) {
            return -1;
        }
        final int m = (int) 1e7;
        int l = 1, r = m + 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(dist, mid, hour)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l > m ? -1 : l;
    }

    private boolean check(int[] dist, int v, double hour) {
        double s = 0;
        int n = dist.length;
        for (int i = 0; i < n; ++i) {
            double t = dist[i] * 1.0 / v;
            s += i == n - 1 ? t : Math.ceil(t);
        }
        return s <= hour;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1870 _tcSol = new Solution1870();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "dist = [1,3,2], hour = 6");
        try {
            int[] dist = new int[]{1, 3, 2};
            double hour = 6.0;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSpeedOnTime(dist, hour)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "dist = [1,3,2], hour = 2.7");
        try {
            int[] dist = new int[]{1, 3, 2};
            double hour = 2.7;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSpeedOnTime(dist, hour)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "dist = [1,3,2], hour = 1.9");
        try {
            int[] dist = new int[]{1, 3, 2};
            double hour = 1.9;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSpeedOnTime(dist, hour)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
