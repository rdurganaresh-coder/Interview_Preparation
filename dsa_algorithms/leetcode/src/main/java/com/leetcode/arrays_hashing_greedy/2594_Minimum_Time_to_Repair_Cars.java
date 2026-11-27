package com.leetcode.arrays_hashing_greedy;

class Solution2594 {
    public long repairCars(int[] ranks, int cars) {
        long left = 0, right = 1L * ranks[0] * cars * cars;
        while (left < right) {
            long mid = (left + right) >> 1;
            long cnt = 0;
            for (int r : ranks) {
                cnt += Math.sqrt(mid / r);
            }
            if (cnt >= cars) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2594 _tcSol = new Solution2594();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "ranks = [4,2,3,1], cars = 10");
        try {
            int[] ranks = new int[]{4, 2, 3, 1};
            int cars = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.repairCars(ranks, cars)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "ranks = [5,1,8], cars = 6");
        try {
            int[] ranks = new int[]{5, 1, 8};
            int cars = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.repairCars(ranks, cars)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}