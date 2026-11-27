package com.leetcode.arrays_hashing_greedy;

class Solution2332 {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int j = 0, c = 0;
        for (int t : buses) {
            c = capacity;
            while (c > 0 && j < passengers.length && passengers[j] <= t) {
                --c;
                ++j;
            }
        }
        --j;
        int ans = c > 0 ? buses[buses.length - 1] : passengers[j];
        while (j >= 0 && ans == passengers[j]) {
            --ans;
            --j;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2332 _tcSol = new Solution2332();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "buses = [10,20], passengers = [2,17,18,19], capacity = 2");
        try {
            int[] buses = new int[]{10, 20};
            int[] passengers = new int[]{2, 17, 18, 19};
            int capacity = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.latestTimeCatchTheBus(buses, passengers, capacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "buses = [20,30,10], passengers = [19,13,26,4,25,11,21], capacity = 2");
        try {
            int[] buses = new int[]{20, 30, 10};
            int[] passengers = new int[]{19, 13, 26, 4, 25, 11, 21};
            int capacity = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.latestTimeCatchTheBus(buses, passengers, capacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();
    }
}