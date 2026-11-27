package com.leetcode.binary_search;

class Solution0081 {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > nums[r]) {
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] < nums[r]) {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                --r;
            }
        }
        return nums[l] == target;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0081 _tcSol = new Solution0081();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,5,6,0,0,1,2], target = 0");
        try {
            int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
            int target = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.search(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,5,6,0,0,1,2], target = 3");
        try {
            int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.search(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}