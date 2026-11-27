package com.leetcode.arrays_hashing_greedy;

class Solution3386 {
    public int buttonWithLongestTime(int[][] events) {
        int ans = events[0][0], t = events[0][1];
        for (int k = 1; k < events.length; ++k) {
            int i = events[k][0], t2 = events[k][1], t1 = events[k - 1][1];
            int d = t2 - t1;
            if (d > t || (d == t && ans > i)) {
                ans = i;
                t = d;
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
        Solution3386 _tcSol = new Solution3386();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "events = [[1,2],[2,5],[3,9],[1,15]]");
        try {
            int[][] events = new int[][]{new int[]{1, 2}, new int[]{2, 5}, new int[]{3, 9}, new int[]{1, 15}};
            System.out.println("  Output  : " + _tcShow(_tcSol.buttonWithLongestTime(events)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "events = [[10,5],[1,7]]");
        try {
            int[][] events = new int[][]{new int[]{10, 5}, new int[]{1, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.buttonWithLongestTime(events)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}
