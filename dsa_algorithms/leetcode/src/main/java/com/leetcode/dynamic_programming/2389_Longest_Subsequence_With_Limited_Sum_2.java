package com.leetcode.dynamic_programming;

class Solution2389_2 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int m = queries.length;
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; ++i) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> queries[i] - queries[j]);
        int[] ans = new int[m];
        int s = 0, j = 0;
        for (int i : idx) {
            while (j < nums.length && s + nums[j] <= queries[i]) {
                s += nums[j++];
            }
            ans[i] = j;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2389_2 _tcSol = new Solution2389_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,5,2,1], queries = [3,10,21]");
        try {
            int[] nums = new int[]{4, 5, 2, 1};
            int[] queries = new int[]{3, 10, 21};
            System.out.println("  Output  : " + _tcShow(_tcSol.answerQueries(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,4,5], queries = [1]");
        try {
            int[] nums = new int[]{2, 3, 4, 5};
            int[] queries = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.answerQueries(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();
    }
}