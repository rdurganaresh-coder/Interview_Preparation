package com.leetcode.sliding_window_two_pointers;

class Solution1438 {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int ans = 0;
        for (int i = 0, j = 0; i < nums.length; ++i) {
            tm.merge(nums[i], 1, Integer::sum);
            for (; tm.lastKey() - tm.firstKey() > limit; ++j) {
                if (tm.merge(nums[j], -1, Integer::sum) == 0) {
                    tm.remove(nums[j]);
                }
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1438 _tcSol = new Solution1438();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [8,2,4,7], limit = 4");
        try {
            int[] nums = new int[]{8, 2, 4, 7};
            int limit = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubarray(nums, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,1,2,4,7,2], limit = 5");
        try {
            int[] nums = new int[]{10, 1, 2, 4, 7, 2};
            int limit = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubarray(nums, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [4,2,2,2,4,4,2,2], limit = 0");
        try {
            int[] nums = new int[]{4, 2, 2, 2, 4, 4, 2, 2};
            int limit = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubarray(nums, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}