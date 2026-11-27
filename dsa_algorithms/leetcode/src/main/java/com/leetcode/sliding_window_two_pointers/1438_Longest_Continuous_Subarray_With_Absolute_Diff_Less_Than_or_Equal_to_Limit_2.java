package com.leetcode.sliding_window_two_pointers;

class Solution1438_2 {
    private int[] nums;
    private int limit;

    public int longestSubarray(int[] nums, int limit) {
        this.nums = nums;
        this.limit = limit;
        int l = 1, r = nums.length;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int k) {
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!minQ.isEmpty() && i - minQ.peekFirst() + 1 > k) {
                minQ.pollFirst();
            }
            if (!maxQ.isEmpty() && i - maxQ.peekFirst() + 1 > k) {
                maxQ.pollFirst();
            }
            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[i]) {
                minQ.pollLast();
            }
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i]) {
                maxQ.pollLast();
            }
            minQ.offer(i);
            maxQ.offer(i);
            if (i >= k - 1 && nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] <= limit) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1438_2 _tcSol = new Solution1438_2();
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