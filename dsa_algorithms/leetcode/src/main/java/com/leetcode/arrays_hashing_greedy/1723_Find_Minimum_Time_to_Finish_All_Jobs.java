package com.leetcode.arrays_hashing_greedy;

class Solution1723 {
    private int[] cnt;
    private int ans;
    private int[] jobs;
    private int k;

    public int minimumTimeRequired(int[] jobs, int k) {
        this.k = k;
        Arrays.sort(jobs);
        for (int i = 0, j = jobs.length - 1; i < j; ++i, --j) {
            int t = jobs[i];
            jobs[i] = jobs[j];
            jobs[j] = t;
        }
        this.jobs = jobs;
        cnt = new int[k];
        ans = 0x3f3f3f3f;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == jobs.length) {
            int mx = 0;
            for (int v : cnt) {
                mx = Math.max(mx, v);
            }
            ans = Math.min(ans, mx);
            return;
        }
        for (int j = 0; j < k; ++j) {
            if (cnt[j] + jobs[i] >= ans) {
                continue;
            }
            cnt[j] += jobs[i];
            dfs(i + 1);
            cnt[j] -= jobs[i];
            if (cnt[j] == 0) {
                break;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1723 _tcSol = new Solution1723();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "jobs = [3,2,3], k = 3");
        try {
            int[] jobs = new int[]{3, 2, 3};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTimeRequired(jobs, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "jobs = [1,2,4,7,8], k = 2");
        try {
            int[] jobs = new int[]{1, 2, 4, 7, 8};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTimeRequired(jobs, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}