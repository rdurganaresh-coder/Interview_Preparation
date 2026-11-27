package com.leetcode.backtracking;

class Solution2044_2 {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int mx = 0;
        for (int mask = 1; mask < 1 << n; ++mask) {
            int t = 0;
            for (int i = 0; i < n; ++i) {
                if (((mask >> i) & 1) == 1) {
                    t |= nums[i];
                }
            }
            if (mx < t) {
                mx = t;
                ans = 1;
            } else if (mx == t) {
                ++ans;
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
        Solution2044_2 _tcSol = new Solution2044_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,1]");
        try {
            int[] nums = new int[]{3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countMaxOrSubsets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,2]");
        try {
            int[] nums = new int[]{2, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.countMaxOrSubsets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,2,1,5]");
        try {
            int[] nums = new int[]{3, 2, 1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.countMaxOrSubsets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}