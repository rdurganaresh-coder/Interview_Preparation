package com.leetcode.arrays_hashing_greedy;

class Solution2009_2 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int m = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }
        int ans = n;
        for (int i = 0, j = 0; i < m; ++i) {
            while (j < m && nums[j] - nums[i] <= n - 1) {
                ++j;
            }
            ans = Math.min(ans, n - (j - i));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2009_2 _tcSol = new Solution2009_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,2,5,3]");
        try {
            int[] nums = new int[]{4, 2, 5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,5,6]");
        try {
            int[] nums = new int[]{1, 2, 3, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,10,100,1000]");
        try {
            int[] nums = new int[]{1, 10, 100, 1000};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}