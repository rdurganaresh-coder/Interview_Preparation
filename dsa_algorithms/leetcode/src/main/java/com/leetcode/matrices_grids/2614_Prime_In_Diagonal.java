package com.leetcode.matrices_grids;

class Solution2614 {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (isPrime(nums[i][i])) {
                ans = Math.max(ans, nums[i][i]);
            }
            if (isPrime(nums[i][n - i - 1])) {
                ans = Math.max(ans, nums[i][n - i - 1]);
            }
        }
        return ans;
    }

    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= x / i; ++i) {
            if (x % i == 0) {
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
        Solution2614 _tcSol = new Solution2614();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [[1,2,3],[5,6,7],[9,10,11]]");
        try {
            int[][] nums = new int[][]{new int[]{1, 2, 3}, new int[]{5, 6, 7}, new int[]{9, 10, 11}};
            System.out.println("  Output  : " + _tcShow(_tcSol.diagonalPrime(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [[1,2,3],[5,17,7],[9,11,10]]");
        try {
            int[][] nums = new int[][]{new int[]{1, 2, 3}, new int[]{5, 17, 7}, new int[]{9, 11, 10}};
            System.out.println("  Output  : " + _tcShow(_tcSol.diagonalPrime(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();
    }
}