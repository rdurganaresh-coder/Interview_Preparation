package com.leetcode.arrays_hashing_greedy;

class Solution2672 {
    public int[] colorTheArray(int n, int[][] queries) {
        int m = queries.length;
        int[] nums = new int[n];
        int[] ans = new int[m];
        for (int k = 0, x = 0; k < m; ++k) {
            int i = queries[k][0], c = queries[k][1];
            if (i > 0 && nums[i] > 0 && nums[i - 1] == nums[i]) {
                --x;
            }
            if (i < n - 1 && nums[i] > 0 && nums[i + 1] == nums[i]) {
                --x;
            }
            if (i > 0 && nums[i - 1] == c) {
                ++x;
            }
            if (i < n - 1 && nums[i + 1] == c) {
                ++x;
            }
            ans[k] = x;
            nums[i] = c;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2672 _tcSol = new Solution2672();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, queries = [[0,2],[1,2],[3,1],[1,1],[2,1]]");
        try {
            int n = 4;
            int[][] queries = new int[][]{new int[]{0, 2}, new int[]{1, 2}, new int[]{3, 1}, new int[]{1, 1}, new int[]{2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.colorTheArray(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,1,0,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1, queries = [[0,100000]]");
        try {
            int n = 1;
            int[][] queries = new int[][]{new int[]{0, 100000}};
            System.out.println("  Output  : " + _tcShow(_tcSol.colorTheArray(n, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();
    }
}