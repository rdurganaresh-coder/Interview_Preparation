package com.leetcode.dynamic_programming;

class Solution1425 {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        int n = nums.length;
        int[] f = new int[n];
        int ans = -(1 << 30);
        for (int i = 0; i < n; ++i) {
            while (i - q.peekFirst() > k) {
                q.pollFirst();
            }
            f[i] = Math.max(0, f[q.peekFirst()]) + nums[i];
            ans = Math.max(ans, f[i]);
            while (!q.isEmpty() && f[q.peekLast()] <= f[i]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1425 _tcSol = new Solution1425();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [10,2,-10,5,20], k = 2");
        try {
            int[] nums = new int[]{10, 2, -10, 5, 20};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.constrainedSubsetSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "37");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,-2,-3], k = 1");
        try {
            int[] nums = new int[]{-1, -2, -3};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.constrainedSubsetSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [10,-2,-10,-5,20], k = 2");
        try {
            int[] nums = new int[]{10, -2, -10, -5, 20};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.constrainedSubsetSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "23");
        System.out.println();
    }
}
