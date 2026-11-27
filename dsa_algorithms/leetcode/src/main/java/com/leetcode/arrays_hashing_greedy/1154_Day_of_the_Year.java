package com.leetcode.arrays_hashing_greedy;

class Solution1154 {
    public int dayOfYear(String date) {
        int y = Integer.parseInt(date.substring(0, 4));
        int m = Integer.parseInt(date.substring(5, 7));
        int d = Integer.parseInt(date.substring(8));
        int v = y % 400 == 0 || (y % 4 == 0 && y % 100 != 0) ? 29 : 28;
        int[] days = {31, v, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ans = d;
        for (int i = 0; i < m - 1; ++i) {
            ans += days[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1154 _tcSol = new Solution1154();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "date = \"2019-01-09\"");
        try {
            String date = "2019-01-09";
            System.out.println("  Output  : " + _tcShow(_tcSol.dayOfYear(date)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "date = \"2019-02-10\"");
        try {
            String date = "2019-02-10";
            System.out.println("  Output  : " + _tcShow(_tcSol.dayOfYear(date)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "41");
        System.out.println();
    }
}