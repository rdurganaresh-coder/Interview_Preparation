package com.leetcode.dynamic_programming;

class Solution1696 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        for (int i = 0; i < n; ++i) {
            if (i - q.peekFirst() > k) {
                q.pollFirst();
            }
            f[i] = nums[i] + f[q.peekFirst()];
            while (!q.isEmpty() && f[q.peekLast()] <= f[i]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        return f[n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1696 _tcSol = new Solution1696();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,-1,-2,4,-7,3], k = 2");
        try {
            int[] nums = new int[]{1, -1, -2, 4, -7, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxResult(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,-5,-2,4,0,3], k = 3");
        try {
            int[] nums = new int[]{10, -5, -2, 4, 0, 3};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxResult(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,-5,-20,4,-1,3,-6,-3], k = 2");
        try {
            int[] nums = new int[]{1, -5, -20, 4, -1, 3, -6, -3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxResult(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}