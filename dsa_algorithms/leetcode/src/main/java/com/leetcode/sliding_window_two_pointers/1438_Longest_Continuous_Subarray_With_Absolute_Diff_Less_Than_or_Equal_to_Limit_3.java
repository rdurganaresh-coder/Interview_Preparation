package com.leetcode.sliding_window_two_pointers;

class Solution1438_3 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
        int n = nums.length;
        int l = 0;
        for (int r = 0; r < n; ++r) {
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[r]) {
                maxQ.pollLast();
            }
            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[r]) {
                minQ.pollLast();
            }
            maxQ.offerLast(r);
            minQ.offerLast(r);
            if (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > limit) {
                ++l;
                if (maxQ.peekFirst() < l) {
                    maxQ.pollFirst();
                }
                if (minQ.peekFirst() < l) {
                    minQ.pollFirst();
                }
            }
        }
        return n - l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1438_3 _tcSol = new Solution1438_3();
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
