package com.leetcode.arrays_hashing_greedy;

class Solution2340 {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        for (int k = 0; k < n; ++k) {
            if (nums[k] < nums[i] || (nums[k] == nums[i] && k < i)) {
                i = k;
            }
            if (nums[k] > nums[j] || (nums[k] == nums[j] && k > j)) {
                j = k;
            }
        }
        if (i == j) {
            return 0;
        }
        return i + n - 1 - j - (i > j ? 1 : 0);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2340 _tcSol = new Solution2340();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,4,5,5,3,1]");
        try {
            int[] nums = new int[]{3, 4, 5, 5, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSwaps(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [9]");
        try {
            int[] nums = new int[]{9};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSwaps(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}