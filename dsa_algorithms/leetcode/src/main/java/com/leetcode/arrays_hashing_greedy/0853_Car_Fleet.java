package com.leetcode.arrays_hashing_greedy;

class Solution0853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> position[j] - position[i]);
        int ans = 0;
        double pre = 0;
        for (int i : idx) {
            double t = 1.0 * (target - position[i]) / speed[i];
            if (t > pre) {
                ++ans;
                pre = t;
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
        Solution0853 _tcSol = new Solution0853();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]");
        try {
            int target = 12;
            int[] position = new int[]{10, 8, 0, 5, 3};
            int[] speed = new int[]{2, 4, 1, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.carFleet(target, position, speed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = 10, position = [3], speed = [3]");
        try {
            int target = 10;
            int[] position = new int[]{3};
            int[] speed = new int[]{3};
            System.out.println("  Output  : " + _tcShow(_tcSol.carFleet(target, position, speed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "target = 100, position = [0,2,4], speed = [4,2,1]");
        try {
            int target = 100;
            int[] position = new int[]{0, 2, 4};
            int[] speed = new int[]{4, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.carFleet(target, position, speed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}