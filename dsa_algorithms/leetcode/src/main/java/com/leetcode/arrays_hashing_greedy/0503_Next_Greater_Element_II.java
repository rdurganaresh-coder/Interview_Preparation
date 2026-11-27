package com.leetcode.arrays_hashing_greedy;

class Solution0503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n * 2 - 1; i >= 0; --i) {
            int j = i % n;
            while (!stk.isEmpty() && stk.peek() <= nums[j]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                ans[j] = stk.peek();
            }
            stk.push(nums[j]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0503 _tcSol = new Solution0503();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1]");
        try {
            int[] nums = new int[]{1, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.nextGreaterElements(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,-1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,3]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.nextGreaterElements(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,4,-1,4]");
        System.out.println();
    }
}