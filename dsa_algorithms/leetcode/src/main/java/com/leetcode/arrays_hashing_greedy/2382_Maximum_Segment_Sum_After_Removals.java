package com.leetcode.arrays_hashing_greedy;

class Solution2382 {
    private int[] p;
    private long[] s;

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        p = new int[n];
        s = new long[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        long[] ans = new long[n];
        long mx = 0;
        for (int j = n - 1; j > 0; --j) {
            int i = removeQueries[j];
            s[i] = nums[i];
            if (i > 0 && s[find(i - 1)] > 0) {
                merge(i, i - 1);
            }
            if (i < n - 1 && s[find(i + 1)] > 0) {
                merge(i, i + 1);
            }
            mx = Math.max(mx, s[find(i)]);
            ans[j - 1] = mx;
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void merge(int a, int b) {
        int pa = find(a), pb = find(b);
        p[pa] = pb;
        s[pb] += s[pa];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2382 _tcSol = new Solution2382();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,5,6,1], removeQueries = [0,3,2,4,1]");
        try {
            int[] nums = new int[]{1, 2, 5, 6, 1};
            int[] removeQueries = new int[]{0, 3, 2, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSegmentSum(nums, removeQueries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[14,7,2,2,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,2,11,1], removeQueries = [3,2,1,0]");
        try {
            int[] nums = new int[]{3, 2, 11, 1};
            int[] removeQueries = new int[]{3, 2, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSegmentSum(nums, removeQueries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[16,5,3,0]");
        System.out.println();
    }
}