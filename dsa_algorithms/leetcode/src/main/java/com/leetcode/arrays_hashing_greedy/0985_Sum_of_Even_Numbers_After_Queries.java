package com.leetcode.arrays_hashing_greedy;

class Solution0985 {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int s = 0;
        for (int x : nums) {
            if (x % 2 == 0) {
                s += x;
            }
        }
        int m = queries.length;
        int[] ans = new int[m];
        int k = 0;
        for (var q : queries) {
            int v = q[0], i = q[1];
            if (nums[i] % 2 == 0) {
                s -= nums[i];
            }
            nums[i] += v;
            if (nums[i] % 2 == 0) {
                s += nums[i];
            }
            ans[k++] = s;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0985 _tcSol = new Solution0985();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            int[][] queries = new int[][]{new int[]{1, 0}, new int[]{-3, 1}, new int[]{-4, 0}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumEvenAfterQueries(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[8,6,2,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1], queries = [[4,0]]");
        try {
            int[] nums = new int[]{1};
            int[][] queries = new int[][]{new int[]{4, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumEvenAfterQueries(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();
    }
}