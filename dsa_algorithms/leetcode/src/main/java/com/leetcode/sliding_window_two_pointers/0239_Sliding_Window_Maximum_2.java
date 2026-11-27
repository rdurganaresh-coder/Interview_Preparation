package com.leetcode.sliding_window_two_pointers;

class Solution0239_2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (!q.isEmpty() && i - q.peekFirst() >= k) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.offerLast(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0239_2 _tcSol = new Solution0239_2();
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
