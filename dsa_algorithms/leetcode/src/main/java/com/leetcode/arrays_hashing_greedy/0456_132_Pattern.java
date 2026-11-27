package com.leetcode.arrays_hashing_greedy;

class Solution0456 {
    public boolean find132pattern(int[] nums) {
        int vk = -(1 << 30);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] < vk) {
                return true;
            }
            while (!stk.isEmpty() && stk.peek() < nums[i]) {
                vk = stk.pop();
            }
            stk.push(nums[i]);
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0456 _tcSol = new Solution0456();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.find132pattern(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,1,4,2]");
        try {
            int[] nums = new int[]{3, 1, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.find132pattern(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-1,3,2,0]");
        try {
            int[] nums = new int[]{-1, 3, 2, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.find132pattern(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}