package com.leetcode.binary_search;

class Solution0153 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > nums[nums.length - 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0153 _tcSol = new Solution0153();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,4,5,1,2]");
        try {
            int[] nums = new int[]{3, 4, 5, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMin(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,5,6,7,0,1,2]");
        try {
            int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMin(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [11,13,15,17]");
        try {
            int[] nums = new int[]{11, 13, 15, 17};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMin(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}
