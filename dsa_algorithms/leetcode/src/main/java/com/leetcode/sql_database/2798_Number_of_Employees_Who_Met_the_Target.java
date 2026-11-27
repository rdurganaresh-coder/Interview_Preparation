package com.leetcode.sql_database;

class Solution2798 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int x : hours) {
            if (x >= target) {
                ++ans;
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
        Solution2798 _tcSol = new Solution2798();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "hours = [0,1,2,3,4], target = 2");
        try {
            int[] hours = new int[]{0, 1, 2, 3, 4};
            int target = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfEmployeesWhoMetTarget(hours, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "hours = [5,1,4,2,2], target = 6");
        try {
            int[] hours = new int[]{5, 1, 4, 2, 2};
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfEmployeesWhoMetTarget(hours, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}