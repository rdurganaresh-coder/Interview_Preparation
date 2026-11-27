package com.leetcode.arrays_hashing_greedy;

class Solution1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] times = new int[n];
        for (int i = 0; i < n; ++i) {
            times[i] = (dist[i] - 1) / speed[i];
        }
        Arrays.sort(times);
        for (int i = 0; i < n; ++i) {
            if (times[i] < i) {
                return i;
            }
        }
        return n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1921 _tcSol = new Solution1921();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "dist = [1,3,4], speed = [1,1,1]");
        try {
            int[] dist = new int[]{1, 3, 4};
            int[] speed = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.eliminateMaximum(dist, speed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "dist = [1,1,2,3], speed = [1,1,1,1]");
        try {
            int[] dist = new int[]{1, 1, 2, 3};
            int[] speed = new int[]{1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.eliminateMaximum(dist, speed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "dist = [3,2,4], speed = [5,3,2]");
        try {
            int[] dist = new int[]{3, 2, 4};
            int[] speed = new int[]{5, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.eliminateMaximum(dist, speed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}