package com.leetcode.sql_database;

class Solution3450 {
    public int maxStudentsOnBench(int[][] students) {
        Map<Integer, Set<Integer>> d = new HashMap<>();
        for (var e : students) {
            int studentId = e[0], benchId = e[1];
            d.computeIfAbsent(benchId, k -> new HashSet<>()).add(studentId);
        }
        int ans = 0;
        for (var s : d.values()) {
            ans = Math.max(ans, s.size());
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3450 _tcSol = new Solution3450();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "students = [[1,2],[2,2],[3,3],[1,3],[2,3]]");
        try {
            int[][] students = new int[][]{new int[]{1, 2}, new int[]{2, 2}, new int[]{3, 3}, new int[]{1, 3}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxStudentsOnBench(students)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "students = [[1,1],[2,1],[3,1],[4,2],[5,2]]");
        try {
            int[][] students = new int[][]{new int[]{1, 1}, new int[]{2, 1}, new int[]{3, 1}, new int[]{4, 2}, new int[]{5, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxStudentsOnBench(students)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "students = [[1,1],[1,1]]");
        try {
            int[][] students = new int[][]{new int[]{1, 1}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxStudentsOnBench(students)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "students = []");
        try {
            int[][] students = new int[][]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxStudentsOnBench(students)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
