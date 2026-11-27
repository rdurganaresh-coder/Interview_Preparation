package com.leetcode.arrays_hashing_greedy;

class Solution2592 {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (int x : nums) {
            if (x > nums[i]) {
                ++i;
            }
        }
        return i;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2592 _tcSol = new Solution2592();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,5,2,1,3,1]");
        try {
            int[] nums = new int[]{1, 3, 5, 2, 1, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeGreatness(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeGreatness(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}