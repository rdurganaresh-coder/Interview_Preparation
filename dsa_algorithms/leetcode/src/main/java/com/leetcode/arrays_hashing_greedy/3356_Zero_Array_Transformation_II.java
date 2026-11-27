package com.leetcode.arrays_hashing_greedy;

class Solution3356 {
    private int n;
    private int[] nums;
    private int[][] queries;

    public int minZeroArray(int[] nums, int[][] queries) {
        this.nums = nums;
        this.queries = queries;
        n = nums.length;
        int m = queries.length;
        int l = 0, r = m + 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l > m ? -1 : l;
    }

    private boolean check(int k) {
        int[] d = new int[n + 1];
        for (int i = 0; i < k; ++i) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            d[l] += val;
            d[r + 1] -= val;
        }
        for (int i = 0, s = 0; i < n; ++i) {
            s += d[i];
            if (nums[i] > s) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3356 _tcSol = new Solution3356();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]");
        try {
            int[] nums = new int[]{2, 0, 2};
            int[][] queries = new int[][]{new int[]{0, 2, 1}, new int[]{0, 2, 1}, new int[]{1, 1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minZeroArray(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]");
        try {
            int[] nums = new int[]{4, 3, 2, 1};
            int[][] queries = new int[][]{new int[]{1, 3, 2}, new int[]{0, 2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minZeroArray(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
