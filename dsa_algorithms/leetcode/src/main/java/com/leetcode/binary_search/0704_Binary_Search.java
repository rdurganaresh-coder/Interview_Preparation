package com.leetcode.binary_search;

class Solution0704 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0704 _tcSol = new Solution0704();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-1,0,3,5,9,12], target = 9");
        try {
            int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
            int target = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.search(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,0,3,5,9,12], target = 2");
        try {
            int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
            int target = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.search(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
