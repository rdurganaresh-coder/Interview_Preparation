package com.leetcode.binary_search;

class Solution0719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) >> 1;
            if (count(mid, nums) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int count(int dist, int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            int left = 0, right = i;
            while (left < right) {
                int mid = (left + right) >> 1;
                int target = nums[i] - dist;
                if (nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            cnt += i - left;
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0719 _tcSol = new Solution0719();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,1], k = 1");
        try {
            int[] nums = new int[]{1, 3, 1};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestDistancePair(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1], k = 2");
        try {
            int[] nums = new int[]{1, 1, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestDistancePair(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,6,1], k = 3");
        try {
            int[] nums = new int[]{1, 6, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestDistancePair(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}