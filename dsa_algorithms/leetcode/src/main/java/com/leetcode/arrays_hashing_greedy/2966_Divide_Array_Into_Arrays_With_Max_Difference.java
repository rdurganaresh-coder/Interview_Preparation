package com.leetcode.arrays_hashing_greedy;

class Solution2966 {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n / 3][];
        for (int i = 0; i < n; i += 3) {
            int[] t = Arrays.copyOfRange(nums, i, i + 3);
            if (t[2] - t[0] > k) {
                return new int[][] {};
            }
            ans[i / 3] = t;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2966 _tcSol = new Solution2966();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,4,8,7,9,3,5,1], k = 2");
        try {
            int[] nums = new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.divideArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,1,3],[3,4,5],[7,8,9]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,4,2,2,5,2], k = 2");
        try {
            int[] nums = new int[]{2, 4, 2, 2, 5, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.divideArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11], k = 14");
        try {
            int[] nums = new int[]{4, 2, 9, 8, 2, 12, 7, 12, 10, 5, 8, 5, 5, 7, 9, 2, 5, 11};
            int k = 14;
            System.out.println("  Output  : " + _tcShow(_tcSol.divideArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,2,2],[4,5,5],[5,5,7],[7,8,8],[9,9,10],[11,12,12]]");
        System.out.println();
    }
}