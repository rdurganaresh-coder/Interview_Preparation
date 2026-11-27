package com.leetcode.binary_search;

class Solution0033 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0033 _tcSol = new Solution0033();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,5,6,7,0,1,2], target = 0");
        try {
            int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
            int target = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.search(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,5,6,7,0,1,2], target = 3");
        try {
            int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.search(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1], target = 0");
        try {
            int[] nums = new int[]{1};
            int target = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.search(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}