package com.leetcode.arrays_hashing_greedy;

class Solution3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] d = new int[n];
        for (int i = 1; i < n; ++i) {
            if (nums[i] % 2 != nums[i - 1] % 2) {
                d[i] = d[i - 1];
            } else {
                d[i] = i;
            }
        }
        int m = queries.length;
        boolean[] ans = new boolean[m];
        for (int i = 0; i < m; ++i) {
            ans[i] = d[queries[i][1]] <= queries[i][0];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3152 _tcSol = new Solution3152();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,4,1,2,6], queries = [[0,4]]");
        try {
            int[] nums = new int[]{3, 4, 1, 2, 6};
            int[][] queries = new int[][]{new int[]{0, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isArraySpecial(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,3,1,6], queries = [[0,2],[2,3]]");
        try {
            int[] nums = new int[]{4, 3, 1, 6};
            int[][] queries = new int[][]{new int[]{0, 2}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.isArraySpecial(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,true]");
        System.out.println();
    }
}