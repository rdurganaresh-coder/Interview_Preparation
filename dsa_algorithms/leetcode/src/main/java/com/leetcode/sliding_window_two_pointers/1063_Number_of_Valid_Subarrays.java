package com.leetcode.sliding_window_two_pointers;

class Solution1063 {
    public int validSubarrays(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += right[i] - i;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1063 _tcSol = new Solution1063();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,4,2,5,3]");
        try {
            int[] nums = new int[]{1, 4, 2, 5, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.validSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,2,1]");
        try {
            int[] nums = new int[]{3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.validSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,2,2]");
        try {
            int[] nums = new int[]{2, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.validSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}