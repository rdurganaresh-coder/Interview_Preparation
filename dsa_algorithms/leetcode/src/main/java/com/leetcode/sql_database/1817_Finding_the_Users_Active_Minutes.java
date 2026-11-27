package com.leetcode.sql_database;

class Solution1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> d = new HashMap<>();
        for (var log : logs) {
            int i = log[0], t = log[1];
            d.computeIfAbsent(i, key -> new HashSet<>()).add(t);
        }
        int[] ans = new int[k];
        for (var ts : d.values()) {
            ++ans[ts.size() - 1];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1817 _tcSol = new Solution1817();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5");
        try {
            int[][] logs = new int[][]{new int[]{0, 5}, new int[]{1, 2}, new int[]{0, 2}, new int[]{0, 5}, new int[]{1, 3}};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.findingUsersActiveMinutes(logs, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2,0,0,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "logs = [[1,1],[2,2],[2,3]], k = 4");
        try {
            int[][] logs = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{2, 3}};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.findingUsersActiveMinutes(logs, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,0,0]");
        System.out.println();
    }
}