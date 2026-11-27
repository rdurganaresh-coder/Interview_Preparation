package com.leetcode.arrays_hashing_greedy;

class Solution2164 {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        int[] a = new int[(n + 1) >> 1];
        int[] b = new int[n >> 1];
        for (int i = 0, j = 0; j < n >> 1; i += 2, ++j) {
            a[j] = nums[i];
            b[j] = nums[i + 1];
        }
        if (n % 2 == 1) {
            a[a.length - 1] = nums[n - 1];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int[] ans = new int[n];
        for (int i = 0, j = 0; j < a.length; i += 2, ++j) {
            ans[i] = a[j];
        }
        for (int i = 1, j = b.length - 1; j >= 0; i += 2, --j) {
            ans[i] = b[j];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2164 _tcSol = new Solution2164();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,1,2,3]");
        try {
            int[] nums = new int[]{4, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortEvenOdd(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,4,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,1]");
        try {
            int[] nums = new int[]{2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortEvenOdd(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1]");
        System.out.println();
    }
}