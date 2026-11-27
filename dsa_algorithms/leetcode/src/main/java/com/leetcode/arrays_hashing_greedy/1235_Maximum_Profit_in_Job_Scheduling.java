package com.leetcode.arrays_hashing_greedy;

class Solution1235 {
    private int[][] jobs;
    private int[] f;
    private int n;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = profit.length;
        jobs = new int[n][3];
        for (int i = 0; i < n; ++i) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        f = new int[n];
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != 0) {
            return f[i];
        }
        int e = jobs[i][1], p = jobs[i][2];
        int j = search(jobs, e, i + 1);
        int ans = Math.max(dfs(i + 1), p + dfs(j));
        f[i] = ans;
        return ans;
    }

    private int search(int[][] jobs, int x, int i) {
        int left = i, right = n;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (jobs[mid][0] >= x) {
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
        Solution1235 _tcSol = new Solution1235();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]");
        try {
            int[] startTime = new int[]{1, 2, 3, 3};
            int[] endTime = new int[]{3, 4, 5, 6};
            int[] profit = new int[]{50, 10, 40, 70};
            System.out.println("  Output  : " + _tcShow(_tcSol.jobScheduling(startTime, endTime, profit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "120");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]");
        try {
            int[] startTime = new int[]{1, 2, 3, 4, 6};
            int[] endTime = new int[]{3, 5, 10, 6, 9};
            int[] profit = new int[]{20, 20, 100, 70, 60};
            System.out.println("  Output  : " + _tcShow(_tcSol.jobScheduling(startTime, endTime, profit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "150");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]");
        try {
            int[] startTime = new int[]{1, 1, 1};
            int[] endTime = new int[]{2, 3, 4};
            int[] profit = new int[]{5, 6, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.jobScheduling(startTime, endTime, profit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
