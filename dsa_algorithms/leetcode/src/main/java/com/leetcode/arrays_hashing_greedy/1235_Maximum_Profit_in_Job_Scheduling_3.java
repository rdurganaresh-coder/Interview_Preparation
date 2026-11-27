package com.leetcode.arrays_hashing_greedy;

class Solution1235_3 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; ++i) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int[] f = new int[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            int e = jobs[i][1], p = jobs[i][2];
            int j = search(jobs, e, i + 1);
            f[i] = Math.max(f[i + 1], p + f[j]);
        }
        return f[0];
    }

    private int search(int[][] jobs, int x, int i) {
        int left = i, right = jobs.length;
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
        Solution1235_3 _tcSol = new Solution1235_3();
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
