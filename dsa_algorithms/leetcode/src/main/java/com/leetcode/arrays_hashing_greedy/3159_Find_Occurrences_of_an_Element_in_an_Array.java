package com.leetcode.arrays_hashing_greedy;

class Solution3159 {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == x) {
                ids.add(i);
            }
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int j = queries[i] - 1;
            ans[i] = j < ids.size() ? ids.get(j) : -1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3159 _tcSol = new Solution3159();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,1,7], queries = [1,3,2,4], x = 1");
        try {
            int[] nums = new int[]{1, 3, 1, 7};
            int[] queries = new int[]{1, 3, 2, 4};
            int x = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.occurrencesOfElement(nums, queries, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,-1,2,-1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3], queries = [10], x = 5");
        try {
            int[] nums = new int[]{1, 2, 3};
            int[] queries = new int[]{10};
            int x = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.occurrencesOfElement(nums, queries, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1]");
        System.out.println();
    }
}