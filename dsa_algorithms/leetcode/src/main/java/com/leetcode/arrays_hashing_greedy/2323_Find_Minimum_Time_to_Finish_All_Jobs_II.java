package com.leetcode.arrays_hashing_greedy;

class Solution2323 {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int ans = 0;
        for (int i = 0; i < jobs.length; ++i) {
            ans = Math.max(ans, (jobs[i] + workers[i] - 1) / workers[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2323 _tcSol = new Solution2323();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "jobs = [5,2,4], workers = [1,7,5]");
        try {
            int[] jobs = new int[]{5, 2, 4};
            int[] workers = new int[]{1, 7, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(jobs, workers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "jobs = [3,18,15,9], workers = [6,5,1,3]");
        try {
            int[] jobs = new int[]{3, 18, 15, 9};
            int[] workers = new int[]{6, 5, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(jobs, workers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}