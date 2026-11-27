package com.leetcode.arrays_hashing_greedy;

class Solution2239 {
    public int findClosestNumber(int[] nums) {
        int ans = 0, d = 1 << 30;
        for (int x : nums) {
            int y = Math.abs(x);
            if (y < d || (y == d && x > ans)) {
                ans = x;
                d = y;
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
        Solution2239 _tcSol = new Solution2239();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-4,-2,1,4,8]");
        try {
            int[] nums = new int[]{-4, -2, 1, 4, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.findClosestNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,-1,1]");
        try {
            int[] nums = new int[]{2, -1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findClosestNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}