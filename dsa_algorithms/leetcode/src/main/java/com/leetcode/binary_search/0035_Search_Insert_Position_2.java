package com.leetcode.binary_search;

class Solution0035_2 {
    public int searchInsert(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        return i < 0 ? -i - 1 : i;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0035_2 _tcSol = new Solution0035_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,5,6], target = 5");
        try {
            int[] nums = new int[]{1, 3, 5, 6};
            int target = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.searchInsert(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,5,6], target = 2");
        try {
            int[] nums = new int[]{1, 3, 5, 6};
            int target = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.searchInsert(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,3,5,6], target = 7");
        try {
            int[] nums = new int[]{1, 3, 5, 6};
            int target = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.searchInsert(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}