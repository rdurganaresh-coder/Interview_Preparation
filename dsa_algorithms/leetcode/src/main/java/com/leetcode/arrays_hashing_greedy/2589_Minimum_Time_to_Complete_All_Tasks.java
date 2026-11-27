package com.leetcode.arrays_hashing_greedy;

class Solution2589 {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int[] vis = new int[2010];
        int ans = 0;
        for (var task : tasks) {
            int start = task[0], end = task[1], duration = task[2];
            for (int i = start; i <= end; ++i) {
                duration -= vis[i];
            }
            for (int i = end; i >= start && duration > 0; --i) {
                if (vis[i] == 0) {
                    --duration;
                    ans += vis[i] = 1;
                }
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
        Solution2589 _tcSol = new Solution2589();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tasks = [[2,3,1],[4,5,1],[1,5,2]]");
        try {
            int[][] tasks = new int[][]{new int[]{2, 3, 1}, new int[]{4, 5, 1}, new int[]{1, 5, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinimumTime(tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tasks = [[1,3,2],[2,5,3],[5,6,2]]");
        try {
            int[][] tasks = new int[][]{new int[]{1, 3, 2}, new int[]{2, 5, 3}, new int[]{5, 6, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinimumTime(tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}