package com.leetcode.dynamic_programming;

class Solution1664 {
    public int waysToMakeFair(int[] nums) {
        int s = 0, r0 = 0;
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            if (i % 2 == 0) {
                r0 += nums[i];
            }
        }
        int[] r = {r0, s - r0};
        int[] l = {0, 0};
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            int x = nums[i];
            r[i % 2] -= x;
            if (l[0] + r[1] == l[1] + r[0]) {
                ++ans;
            }
            l[i % 2] += x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1664 _tcSol = new Solution1664();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,6,4]");
        try {
            int[] nums = new int[]{2, 1, 6, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToMakeFair(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToMakeFair(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3]");
        try {
            int[] nums = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToMakeFair(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
