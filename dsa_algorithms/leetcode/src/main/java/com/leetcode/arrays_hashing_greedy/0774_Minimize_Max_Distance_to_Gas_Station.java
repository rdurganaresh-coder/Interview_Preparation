package com.leetcode.arrays_hashing_greedy;

class Solution0774 {
    public double minmaxGasDist(int[] stations, int k) {
        double left = 0, right = 1e8;
        while (right - left > 1e-6) {
            double mid = (left + right) / 2.0;
            if (check(mid, stations, k)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private boolean check(double x, int[] stations, int k) {
        int s = 0;
        for (int i = 0; i < stations.length - 1; ++i) {
            s += (int) ((stations[i + 1] - stations[i]) / x);
        }
        return s <= k;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0774 _tcSol = new Solution0774();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stations = [1,2,3,4,5,6,7,8,9,10], k = 9");
        try {
            int[] stations = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int k = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.minmaxGasDist(stations, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0.50000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stations = [23,24,36,39,46,56,57,65,84,98], k = 1");
        try {
            int[] stations = new int[]{23, 24, 36, 39, 46, 56, 57, 65, 84, 98};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minmaxGasDist(stations, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14.00000");
        System.out.println();
    }
}