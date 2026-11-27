package com.leetcode.arrays_hashing_greedy;

class Solution1150_2 {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int left = search(nums, target);
        int right = left + n / 2;
        return right < n && nums[right] == target;
    }

    private int search(int[] nums, int x) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
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
        Solution1150_2 _tcSol = new Solution1150_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,4,5,5,5,5,5,6,6], target = 5");
        try {
            int[] nums = new int[]{2, 4, 5, 5, 5, 5, 5, 6, 6};
            int target = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.isMajorityElement(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,100,101,101], target = 101");
        try {
            int[] nums = new int[]{10, 100, 101, 101};
            int target = 101;
            System.out.println("  Output  : " + _tcShow(_tcSol.isMajorityElement(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}