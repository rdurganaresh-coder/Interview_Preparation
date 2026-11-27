package com.leetcode.arrays_hashing_greedy;

class Solution0034 {
    public int[] searchRange(int[] nums, int target) {
        int l = search(nums, target);
        int r = search(nums, target + 1);
        return l == r ? new int[] {-1, -1} : new int[] {l, r - 1};
    }

    private int search(int[] nums, int x) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= x) {
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
        Solution0034 _tcSol = new Solution0034();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,7,7,8,8,10], target = 8");
        try {
            int[] nums = new int[]{5, 7, 7, 8, 8, 10};
            int target = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.searchRange(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,7,7,8,8,10], target = 6");
        try {
            int[] nums = new int[]{5, 7, 7, 8, 8, 10};
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.searchRange(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [], target = 0");
        try {
            int[] nums = new int[]{};
            int target = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.searchRange(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1]");
        System.out.println();
    }
}