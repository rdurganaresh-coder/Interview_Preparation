package com.leetcode.arrays_hashing_greedy;

class Solution1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int s = Arrays.stream(distance).sum();
        int n = distance.length, t = 0;
        while (start != destination) {
            t += distance[start];
            start = (start + 1) % n;
        }
        return Math.min(t, s - t);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1184 _tcSol = new Solution1184();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "distance = [1,2,3,4], start = 0, destination = 1");
        try {
            int[] distance = new int[]{1, 2, 3, 4};
            int start = 0;
            int destination = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.distanceBetweenBusStops(distance, start, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "distance = [1,2,3,4], start = 0, destination = 2");
        try {
            int[] distance = new int[]{1, 2, 3, 4};
            int start = 0;
            int destination = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.distanceBetweenBusStops(distance, start, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "distance = [1,2,3,4], start = 0, destination = 3");
        try {
            int[] distance = new int[]{1, 2, 3, 4};
            int start = 0;
            int destination = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.distanceBetweenBusStops(distance, start, destination)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
