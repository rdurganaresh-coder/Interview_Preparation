package com.leetcode.arrays_hashing_greedy;

class Solution1608_2 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int x = 1; x <= n; ++x) {
            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (nums[mid] >= x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int cnt = n - left;
            if (cnt == x) {
                return x;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1608_2 _tcSol = new Solution1608_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,5]");
        try {
            int[] nums = new int[]{3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.specialArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,0]");
        try {
            int[] nums = new int[]{0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.specialArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [0,4,3,0,4]");
        try {
            int[] nums = new int[]{0, 4, 3, 0, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.specialArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}