package com.leetcode.binary_search;

class Solution0154 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] == nums[r]) {
                r--;
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
        Solution0154 _tcSol = new Solution0154();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,5]");
        try {
            int[] nums = new int[]{1, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMin(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,2,0,1]");
        try {
            int[] nums = new int[]{2, 2, 2, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMin(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
