package com.leetcode.arrays_hashing_greedy;

class Solution0826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int n = profit.length;
        int[][] jobs = new int[n][0];
        for (int i = 0; i < n; ++i) {
            jobs[i] = new int[] {difficulty[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int ans = 0, mx = 0, i = 0;
        for (int w : worker) {
            while (i < n && jobs[i][0] <= w) {
                mx = Math.max(mx, jobs[i++][1]);
            }
            ans += mx;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0826 _tcSol = new Solution0826();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]");
        try {
            int[] difficulty = new int[]{2, 4, 6, 8, 10};
            int[] profit = new int[]{10, 20, 30, 40, 50};
            int[] worker = new int[]{4, 5, 6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfitAssignment(difficulty, profit, worker)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "100");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]");
        try {
            int[] difficulty = new int[]{85, 47, 57};
            int[] profit = new int[]{24, 66, 99};
            int[] worker = new int[]{40, 25, 25};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxProfitAssignment(difficulty, profit, worker)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}