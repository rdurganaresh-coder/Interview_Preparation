package com.leetcode.sliding_window_two_pointers;

class Solution0239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> q
            = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int n = nums.length;
        for (int i = 0; i < k - 1; ++i) {
            q.offer(new int[] {nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        for (int i = k - 1, j = 0; i < n; ++i) {
            q.offer(new int[] {nums[i], i});
            while (q.peek()[1] <= i - k) {
                q.poll();
            }
            ans[j++] = q.peek()[0];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0239 _tcSol = new Solution0239();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,-1,-3,5,3,6,7], k = 3");
        try {
            int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSlidingWindow(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3,5,5,6,7]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1], k = 1");
        try {
            int[] nums = new int[]{1};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSlidingWindow(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();
    }
}