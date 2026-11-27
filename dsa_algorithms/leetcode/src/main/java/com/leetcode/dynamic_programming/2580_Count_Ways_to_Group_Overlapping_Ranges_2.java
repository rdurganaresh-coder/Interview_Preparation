package com.leetcode.dynamic_programming;

class Solution2580_2 {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int mx = -1;
        int ans = 1;
        final int mod = (int) 1e9 + 7;
        for (int[] e : ranges) {
            if (e[0] > mx) {
                ans = ans * 2 % mod;
            }
            mx = Math.max(mx, e[1]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2580_2 _tcSol = new Solution2580_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "ranges = [[6,10],[5,15]]");
        try {
            int[][] ranges = new int[][]{new int[]{6, 10}, new int[]{5, 15}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countWays(ranges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "ranges = [[1,3],[10,20],[2,5],[4,8]]");
        try {
            int[][] ranges = new int[][]{new int[]{1, 3}, new int[]{10, 20}, new int[]{2, 5}, new int[]{4, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countWays(ranges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}