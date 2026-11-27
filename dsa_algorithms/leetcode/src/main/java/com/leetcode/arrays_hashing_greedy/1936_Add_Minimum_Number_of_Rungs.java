package com.leetcode.arrays_hashing_greedy;

class Solution1936 {
    public int addRungs(int[] rungs, int dist) {
        int ans = 0, prev = 0;
        for (int x : rungs) {
            ans += (x - prev - 1) / dist;
            prev = x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1936 _tcSol = new Solution1936();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rungs = [1,3,5,10], dist = 2");
        try {
            int[] rungs = new int[]{1, 3, 5, 10};
            int dist = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.addRungs(rungs, dist)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rungs = [3,6,8,10], dist = 3");
        try {
            int[] rungs = new int[]{3, 6, 8, 10};
            int dist = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.addRungs(rungs, dist)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "rungs = [3,4,6,7], dist = 2");
        try {
            int[] rungs = new int[]{3, 4, 6, 7};
            int dist = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.addRungs(rungs, dist)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}