package com.leetcode.bit_manipulation_math;

class Solution3312 {
    public int[] gcdValues(int[] nums, long[] queries) {
        int mx = Arrays.stream(nums).max().getAsInt();
        int[] cnt = new int[mx + 1];
        long[] cntG = new long[mx + 1];
        for (int x : nums) {
            ++cnt[x];
        }
        for (int i = mx; i > 0; --i) {
            int v = 0;
            for (int j = i; j <= mx; j += i) {
                v += cnt[j];
                cntG[i] -= cntG[j];
            }
            cntG[i] += 1L * v * (v - 1) / 2;
        }
        for (int i = 2; i <= mx; ++i) {
            cntG[i] += cntG[i - 1];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            ans[i] = search(cntG, queries[i]);
        }
        return ans;
    }

    private int search(long[] nums, long x) {
        int n = nums.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3312 _tcSol = new Solution3312();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,4], queries = [0,2,2]");
        try {
            int[] nums = new int[]{2, 3, 4};
            long[] queries = new long[]{0L, 2L, 2L};
            System.out.println("  Output  : " + _tcShow(_tcSol.gcdValues(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,4,2,1], queries = [5,3,1,0]");
        try {
            int[] nums = new int[]{4, 4, 2, 1};
            long[] queries = new long[]{5L, 3L, 1L, 0L};
            System.out.println("  Output  : " + _tcShow(_tcSol.gcdValues(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,2,1,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,2], queries = [0,0]");
        try {
            int[] nums = new int[]{2, 2};
            long[] queries = new long[]{0L, 0L};
            System.out.println("  Output  : " + _tcShow(_tcSol.gcdValues(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2]");
        System.out.println();
    }
}
