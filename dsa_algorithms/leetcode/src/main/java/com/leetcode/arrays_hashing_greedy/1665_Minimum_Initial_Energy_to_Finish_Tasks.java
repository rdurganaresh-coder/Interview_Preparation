package com.leetcode.arrays_hashing_greedy;

class Solution1665 {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[0] - b[0] - (a[1] - b[1]));
        int ans = 0, cur = 0;
        for (var task : tasks) {
            int a = task[0], m = task[1];
            if (cur < m) {
                ans += m - cur;
                cur = m;
            }
            cur -= a;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1665 _tcSol = new Solution1665();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tasks = [[1,2],[2,4],[4,8]]");
        try {
            int[][] tasks = new int[][]{new int[]{1, 2}, new int[]{2, 4}, new int[]{4, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumEffort(tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tasks = [[1,3],[2,4],[10,11],[10,12],[8,9]]");
        try {
            int[][] tasks = new int[][]{new int[]{1, 3}, new int[]{2, 4}, new int[]{10, 11}, new int[]{10, 12}, new int[]{8, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumEffort(tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "32");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "tasks = [[1,7],[2,8],[3,9],[4,10],[5,11],[6,12]]");
        try {
            int[][] tasks = new int[][]{new int[]{1, 7}, new int[]{2, 8}, new int[]{3, 9}, new int[]{4, 10}, new int[]{5, 11}, new int[]{6, 12}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumEffort(tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "27");
        System.out.println();
    }
}