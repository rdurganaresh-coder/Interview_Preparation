package com.leetcode.arrays_hashing_greedy;

class Solution2948 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> nums[i] - nums[j]);
        int[] ans = new int[n];
        for (int i = 0; i < n;) {
            int j = i + 1;
            while (j < n && nums[idx[j]] - nums[idx[j - 1]] <= limit) {
                ++j;
            }
            Integer[] t = Arrays.copyOfRange(idx, i, j);
            Arrays.sort(t, (x, y) -> x - y);
            for (int k = i; k < j; ++k) {
                ans[t[k - i]] = nums[idx[k]];
            }
            i = j;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2948 _tcSol = new Solution2948();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,5,3,9,8], limit = 2");
        try {
            int[] nums = new int[]{1, 5, 3, 9, 8};
            int limit = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.lexicographicallySmallestArray(nums, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3,5,8,9]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,7,6,18,2,1], limit = 3");
        try {
            int[] nums = new int[]{1, 7, 6, 18, 2, 1};
            int limit = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.lexicographicallySmallestArray(nums, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,6,7,18,1,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,7,28,19,10], limit = 3");
        try {
            int[] nums = new int[]{1, 7, 28, 19, 10};
            int limit = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.lexicographicallySmallestArray(nums, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,7,28,19,10]");
        System.out.println();
    }
}