package com.leetcode.arrays_hashing_greedy;

class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = search(arr, nums[i]);
        }
        return nums;
    }

    private int search(int[] nums, int x) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1365 _tcSol = new Solution1365();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [8,1,2,2,3]");
        try {
            int[] nums = new int[]{8, 1, 2, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallerNumbersThanCurrent(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,0,1,1,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [6,5,4,8]");
        try {
            int[] nums = new int[]{6, 5, 4, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallerNumbersThanCurrent(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1,0,3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [7,7,7,7]");
        try {
            int[] nums = new int[]{7, 7, 7, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallerNumbersThanCurrent(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,0,0]");
        System.out.println();
    }
}