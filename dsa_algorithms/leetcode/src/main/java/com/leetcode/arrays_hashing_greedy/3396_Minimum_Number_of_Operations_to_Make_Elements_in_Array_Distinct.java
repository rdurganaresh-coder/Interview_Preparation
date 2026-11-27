package com.leetcode.arrays_hashing_greedy;

class Solution3396 {
    public int minimumOperations(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            if (!s.add(nums[i])) {
                return i / 3 + 1;
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3396 _tcSol = new Solution3396();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,2,3,3,5,7]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,5,6,4,4]");
        try {
            int[] nums = new int[]{4, 5, 6, 4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [6,7,8,9]");
        try {
            int[] nums = new int[]{6, 7, 8, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
