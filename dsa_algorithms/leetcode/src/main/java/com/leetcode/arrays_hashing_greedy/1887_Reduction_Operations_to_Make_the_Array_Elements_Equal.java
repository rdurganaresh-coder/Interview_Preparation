package com.leetcode.arrays_hashing_greedy;

class Solution1887 {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, cnt = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                ++cnt;
            }
            ans += cnt;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1887 _tcSol = new Solution1887();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,1,3]");
        try {
            int[] nums = new int[]{5, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.reductionOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.reductionOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,2,2,3]");
        try {
            int[] nums = new int[]{1, 1, 2, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.reductionOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}