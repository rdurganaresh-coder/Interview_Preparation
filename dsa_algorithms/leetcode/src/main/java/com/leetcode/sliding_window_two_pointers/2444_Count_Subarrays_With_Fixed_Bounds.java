package com.leetcode.sliding_window_two_pointers;

class Solution2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int j1 = -1, j2 = -1, k = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                k = i;
            }
            if (nums[i] == minK) {
                j1 = i;
            }
            if (nums[i] == maxK) {
                j2 = i;
            }
            ans += Math.max(0, Math.min(j1, j2) - k);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2444 _tcSol = new Solution2444();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,5,2,7,5], minK = 1, maxK = 5");
        try {
            int[] nums = new int[]{1, 3, 5, 2, 7, 5};
            int minK = 1;
            int maxK = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums, minK, maxK)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1,1], minK = 1, maxK = 1");
        try {
            int[] nums = new int[]{1, 1, 1, 1};
            int minK = 1;
            int maxK = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums, minK, maxK)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}