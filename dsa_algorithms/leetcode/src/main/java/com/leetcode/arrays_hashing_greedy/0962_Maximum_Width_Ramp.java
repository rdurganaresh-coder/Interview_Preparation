package com.leetcode.arrays_hashing_greedy;

class Solution0962 {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (stk.isEmpty() || nums[stk.peek()] > nums[i]) {
                stk.push(i);
            }
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && nums[stk.peek()] <= nums[i]) {
                ans = Math.max(ans, i - stk.pop());
            }
            if (stk.isEmpty()) {
                break;
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
        Solution0962 _tcSol = new Solution0962();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [6,0,8,2,1,5]");
        try {
            int[] nums = new int[]{6, 0, 8, 2, 1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxWidthRamp(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [9,8,1,0,1,9,4,0,4,1]");
        try {
            int[] nums = new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxWidthRamp(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}