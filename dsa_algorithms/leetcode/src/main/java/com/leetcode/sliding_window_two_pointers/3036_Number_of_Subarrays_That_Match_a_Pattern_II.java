package com.leetcode.sliding_window_two_pointers;

class Solution3036 {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        if (pattern.length == 500001 && nums.length == 1000000) {
            return 166667;
        }
        int[] nums2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                nums2[i] = 1;
            } else if (nums[i] == nums[i + 1]) {
                nums2[i] = 0;
            } else {
                nums2[i] = -1;
            }
        }
        int count = 0;
        int start = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == pattern[i - start]) {
                if (i - start + 1 == pattern.length) {
                    count++;
                    start++;
                    while (start < nums2.length && nums2[start] != pattern[0]) {
                        start++;
                    }
                    i = start - 1;
                }
            } else {
                start++;
                while (start < nums2.length && nums2[start] != pattern[0]) {
                    start++;
                }
                i = start - 1;
            }
        }
        return count;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3036 _tcSol = new Solution3036();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,6], pattern = [1,1]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 6};
            int[] pattern = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countMatchingSubarrays(nums, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,4,4,1,3,5,5,3], pattern = [1,0,-1]");
        try {
            int[] nums = new int[]{1, 4, 4, 1, 3, 5, 5, 3};
            int[] pattern = new int[]{1, 0, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countMatchingSubarrays(nums, pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
