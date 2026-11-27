package com.leetcode.sql_database;

class Solution2064 {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = (int) 1e5;
        while (left < right) {
            int mid = (left + right) >> 1;
            int cnt = 0;
            for (int v : quantities) {
                cnt += (v + mid - 1) / mid;
            }
            if (cnt <= n) {
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
        Solution2064 _tcSol = new Solution2064();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, quantities = [11,6]");
        try {
            int n = 6;
            int[] quantities = new int[]{11, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizedMaximum(n, quantities)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 7, quantities = [15,10,10]");
        try {
            int n = 7;
            int[] quantities = new int[]{15, 10, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizedMaximum(n, quantities)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 1, quantities = [100000]");
        try {
            int n = 1;
            int[] quantities = new int[]{100000};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizedMaximum(n, quantities)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "100000");
        System.out.println();
    }
}