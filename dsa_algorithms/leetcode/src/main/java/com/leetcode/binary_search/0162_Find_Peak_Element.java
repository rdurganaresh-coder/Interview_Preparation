package com.leetcode.binary_search;

class Solution0162 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0162 _tcSol = new Solution0162();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,1]");
        try {
            int[] nums = new int[]{1, 2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findPeakElement(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,1,3,5,6,4]");
        try {
            int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findPeakElement(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}