package com.leetcode.arrays_hashing_greedy;

class Solution3080 {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        long s = Arrays.stream(nums).asLongStream().sum();
        boolean[] mark = new boolean[n];
        int[][] arr = new int[n][0];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {nums[i], i};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int m = queries.length;
        long[] ans = new long[m];
        for (int i = 0, j = 0; i < m; ++i) {
            int index = queries[i][0], k = queries[i][1];
            if (!mark[index]) {
                mark[index] = true;
                s -= nums[index];
            }
            for (; k > 0 && j < n; ++j) {
                if (!mark[arr[j][1]]) {
                    mark[arr[j][1]] = true;
                    s -= arr[j][0];
                    --k;
                }
            }
            ans[i] = s;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3080 _tcSol = new Solution3080();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2,1,2,3,1], queries = [[1,2],[3,3],[4,2]]");
        try {
            int[] nums = new int[]{1, 2, 2, 1, 2, 3, 1};
            int[][] queries = new int[][]{new int[]{1, 2}, new int[]{3, 3}, new int[]{4, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.unmarkedSumArray(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[8,3,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,4,2,3], queries = [[0,1]]");
        try {
            int[] nums = new int[]{1, 4, 2, 3};
            int[][] queries = new int[][]{new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.unmarkedSumArray(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[7]");
        System.out.println();
    }
}