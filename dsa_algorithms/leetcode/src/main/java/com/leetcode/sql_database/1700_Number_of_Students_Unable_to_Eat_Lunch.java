package com.leetcode.sql_database;

class Solution1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnt = new int[2];
        for (int v : students) {
            ++cnt[v];
        }
        for (int v : sandwiches) {
            if (cnt[v]-- == 0) {
                return cnt[v ^ 1];
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1700 _tcSol = new Solution1700();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "students = [1,1,0,0], sandwiches = [0,1,0,1]");
        try {
            int[] students = new int[]{1, 1, 0, 0};
            int[] sandwiches = new int[]{0, 1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countStudents(students, sandwiches)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]");
        try {
            int[] students = new int[]{1, 1, 1, 0, 0, 1};
            int[] sandwiches = new int[]{1, 0, 0, 0, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countStudents(students, sandwiches)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}