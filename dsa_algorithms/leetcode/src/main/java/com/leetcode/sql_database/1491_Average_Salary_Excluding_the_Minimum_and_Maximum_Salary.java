package com.leetcode.sql_database;

class Solution1491 {
    public double average(int[] salary) {
        int s = 0;
        int mi = 10000000, mx = 0;
        for (int v : salary) {
            mi = Math.min(mi, v);
            mx = Math.max(mx, v);
            s += v;
        }
        s -= (mi + mx);
        return s * 1.0 / (salary.length - 2);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1491 _tcSol = new Solution1491();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "salary = [4000,3000,1000,2000]");
        try {
            int[] salary = new int[]{4000, 3000, 1000, 2000};
            System.out.println("  Output  : " + _tcShow(_tcSol.average(salary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2500.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "salary = [1000,2000,3000]");
        try {
            int[] salary = new int[]{1000, 2000, 3000};
            System.out.println("  Output  : " + _tcShow(_tcSol.average(salary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2000.00000");
        System.out.println();
    }
}