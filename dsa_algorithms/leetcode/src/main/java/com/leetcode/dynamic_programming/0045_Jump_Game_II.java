package com.leetcode.dynamic_programming;

class Solution0045 {
    public int jump(int[] nums) {
        int ans = 0, mx = 0, last = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            mx = Math.max(mx, i + nums[i]);
            if (last == i) {
                ++ans;
                last = mx;
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
        Solution0045 _tcSol = new Solution0045();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,1,1,4]");
        try {
            int[] nums = new int[]{2, 3, 1, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.jump(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,0,1,4]");
        try {
            int[] nums = new int[]{2, 3, 0, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.jump(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}