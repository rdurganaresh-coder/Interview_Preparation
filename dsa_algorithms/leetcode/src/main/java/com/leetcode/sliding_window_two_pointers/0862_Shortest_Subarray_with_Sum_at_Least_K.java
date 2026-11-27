package com.leetcode.sliding_window_two_pointers;

class Solution0862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
        Deque<Integer> q = new ArrayDeque<>();
        int ans = n + 1;
        for (int i = 0; i <= n; ++i) {
            while (!q.isEmpty() && s[i] - s[q.peek()] >= k) {
                ans = Math.min(ans, i - q.poll());
            }
            while (!q.isEmpty() && s[q.peekLast()] >= s[i]) {
                q.pollLast();
            }
            q.offer(i);
        }
        return ans > n ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0862 _tcSol = new Solution0862();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1], k = 1");
        try {
            int[] nums = new int[]{1};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestSubarray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2], k = 4");
        try {
            int[] nums = new int[]{1, 2};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestSubarray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,-1,2], k = 3");
        try {
            int[] nums = new int[]{2, -1, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestSubarray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}