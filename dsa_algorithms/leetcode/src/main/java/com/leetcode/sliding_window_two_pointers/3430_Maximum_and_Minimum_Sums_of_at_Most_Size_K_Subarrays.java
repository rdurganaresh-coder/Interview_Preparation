package com.leetcode.sliding_window_two_pointers;

class Solution3430 {
    public long minMaxSubarraySum(int[] nums, int k) {
        long total = 0, windowMax = 0, windowMin = 0;
        Deque<long[]> maxStack = new ArrayDeque<>();
        Deque<long[]> minStack = new ArrayDeque<>();
        for (int end = 0; end < nums.length; ++end) {
            int start = Math.max(0, end - k + 1);
            if (start > 0) {
                maxStack.peekFirst()[2]--;
                windowMax -= maxStack.peekFirst()[1];
                if (maxStack.peekFirst()[0] < start) {
                    maxStack.pollFirst();
                }
                minStack.peekFirst()[2]--;
                windowMin -= minStack.peekFirst()[1];
                if (minStack.peekFirst()[0] < start) {
                    minStack.pollFirst();
                }
            }
            long num = nums[end];
            long maxShares = 1;
            windowMax += num;
            while (!maxStack.isEmpty() && maxStack.peekLast()[1] <= num) {
                long prevNum = maxStack.peekLast()[1];
                long prevShares = maxStack.pollLast()[2];
                maxShares += prevShares;
                windowMax += (num - prevNum) * prevShares;
            }
            maxStack.addLast(new long[] {end, num, maxShares});
            long minShares = 1;
            windowMin += num;
            while (!minStack.isEmpty() && minStack.peekLast()[1] >= num) {
                long prevNum = minStack.peekLast()[1];
                long prevShares = minStack.pollLast()[2];
                minShares += prevShares;
                windowMin += (num - prevNum) * prevShares;
            }
            minStack.addLast(new long[] {end, num, minShares});
            total += windowMax + windowMin;
        }
        return total;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3430 _tcSol = new Solution3430();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3], k = 2");
        try {
            int[] nums = new int[]{1, 2, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMaxSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,-3,1], k = 2");
        try {
            int[] nums = new int[]{1, -3, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMaxSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-6");
        System.out.println();
    }
}
