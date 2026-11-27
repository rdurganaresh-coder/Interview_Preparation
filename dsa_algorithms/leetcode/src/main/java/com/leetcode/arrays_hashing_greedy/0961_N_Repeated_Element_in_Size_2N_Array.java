package com.leetcode.arrays_hashing_greedy;

class Solution0961 {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> s = new HashSet<>(nums.length / 2 + 1);
        for (int i = 0;; ++i) {
            if (!s.add(nums[i])) {
                return nums[i];
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0961 _tcSol = new Solution0961();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,3]");
        try {
            int[] nums = new int[]{1, 2, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.repeatedNTimes(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,1,2,5,3,2]");
        try {
            int[] nums = new int[]{2, 1, 2, 5, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.repeatedNTimes(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [5,1,5,2,5,3,5,4]");
        try {
            int[] nums = new int[]{5, 1, 5, 2, 5, 3, 5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.repeatedNTimes(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}