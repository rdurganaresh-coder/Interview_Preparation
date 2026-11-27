package com.leetcode.arrays_hashing_greedy;

class Solution1060 {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        if (k > missing(nums, n - 1)) {
            return nums[n - 1] + k - missing(nums, n - 1);
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (missing(nums, mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l - 1] + k - missing(nums, l - 1);
    }

    private int missing(int[] nums, int i) {
        return nums[i] - nums[0] - i;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1060 _tcSol = new Solution1060();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,7,9,10], k = 1");
        try {
            int[] nums = new int[]{4, 7, 9, 10};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.missingElement(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,7,9,10], k = 3");
        try {
            int[] nums = new int[]{4, 7, 9, 10};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.missingElement(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,4], k = 3");
        try {
            int[] nums = new int[]{1, 2, 4};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.missingElement(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}