package com.leetcode.arrays_hashing_greedy;

class Solution3169 {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int ans = 0, last = 0;
        for (var e : meetings) {
            int st = e[0], ed = e[1];
            if (last < st) {
                ans += st - last - 1;
            }
            last = Math.max(last, ed);
        }
        ans += days - last;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3169 _tcSol = new Solution3169();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "days = 10, meetings = [[5,7],[1,3],[9,10]]");
        try {
            int days = 10;
            int[][] meetings = new int[][]{new int[]{5, 7}, new int[]{1, 3}, new int[]{9, 10}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countDays(days, meetings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "days = 5, meetings = [[2,4],[1,3]]");
        try {
            int days = 5;
            int[][] meetings = new int[][]{new int[]{2, 4}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countDays(days, meetings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "days = 6, meetings = [[1,6]]");
        try {
            int days = 6;
            int[][] meetings = new int[][]{new int[]{1, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countDays(days, meetings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}