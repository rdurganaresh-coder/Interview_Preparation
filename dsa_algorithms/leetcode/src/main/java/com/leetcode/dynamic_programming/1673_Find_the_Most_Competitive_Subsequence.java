package com.leetcode.dynamic_programming;

class Solution1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stk = new ArrayDeque<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            while (!stk.isEmpty() && stk.peek() > nums[i] && stk.size() + n - i > k) {
                stk.pop();
            }
            if (stk.size() < k) {
                stk.push(nums[i]);
            }
        }
        int[] ans = new int[stk.size()];
        for (int i = ans.length - 1; i >= 0; --i) {
            ans[i] = stk.pop();
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1673 _tcSol = new Solution1673();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,5,2,6], k = 2");
        try {
            int[] nums = new int[]{3, 5, 2, 6};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.mostCompetitive(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,6]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,4,3,3,5,4,9,6], k = 4");
        try {
            int[] nums = new int[]{2, 4, 3, 3, 5, 4, 9, 6};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.mostCompetitive(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,3,4]");
        System.out.println();
    }
}