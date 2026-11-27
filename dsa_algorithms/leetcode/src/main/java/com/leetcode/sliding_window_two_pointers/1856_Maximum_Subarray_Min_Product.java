package com.leetcode.sliding_window_two_pointers;

class Solution1856 {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && nums[stk.peek()] > nums[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        long[] s = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, nums[i] * (s[right[i]] - s[left[i] + 1]));
        }
        final int mod = (int) 1e9 + 7;
        return (int) (ans % mod);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1856 _tcSol = new Solution1856();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,2]");
        try {
            int[] nums = new int[]{1, 2, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumMinProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,3,1,2]");
        try {
            int[] nums = new int[]{2, 3, 3, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumMinProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,1,5,6,4,2]");
        try {
            int[] nums = new int[]{3, 1, 5, 6, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumMinProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "60");
        System.out.println();
    }
}