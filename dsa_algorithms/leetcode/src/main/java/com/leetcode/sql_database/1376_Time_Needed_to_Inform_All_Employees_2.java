package com.leetcode.sql_database;

class Solution1376_2 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            if (manager[i] >= 0) {
                g[manager[i]].add(i);
            }
        }
        int[] time = new int[n];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {headID, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], state = cur[1];
            if (state == 0) {
                stk.push(new int[] {i, 1});
                for (int j : g[i]) {
                    stk.push(new int[] {j, 0});
                }
            } else {
                int ans = 0;
                for (int j : g[i]) {
                    ans = Math.max(ans, time[j] + informTime[i]);
                }
                time[i] = ans;
            }
        }
        return time[headID];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1376_2 _tcSol = new Solution1376_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1, headID = 0, manager = [-1], informTime = [0]");
        try {
            int n = 1;
            int headID = 0;
            int[] manager = new int[]{-1};
            int[] informTime = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfMinutes(n, headID, manager, informTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]");
        try {
            int n = 6;
            int headID = 2;
            int[] manager = new int[]{2, 2, -1, 2, 2, 2};
            int[] informTime = new int[]{0, 0, 1, 0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfMinutes(n, headID, manager, informTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
