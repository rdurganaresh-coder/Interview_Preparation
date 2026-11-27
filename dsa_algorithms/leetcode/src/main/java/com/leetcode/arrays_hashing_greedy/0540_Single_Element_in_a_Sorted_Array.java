package com.leetcode.arrays_hashing_greedy;

class Solution0540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] != nums[mid ^ 1]) {
                r = mid;
            } else {
                l = mid + 1;
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
        Solution0540 _tcSol = new Solution0540();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,2,3,3,4,4,8,8]");
        try {
            int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.singleNonDuplicate(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,3,7,7,10,11,11]");
        try {
            int[] nums = new int[]{3, 3, 7, 7, 10, 11, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.singleNonDuplicate(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}
