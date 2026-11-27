package com.leetcode.arrays_hashing_greedy;

class Solution1995_2 {
    public int countQuadruplets(int[] nums) {
        int ans = 0, n = nums.length;
        int[] counter = new int[310];
        for (int c = n - 2; c > 1; --c) {
            ++counter[nums[c + 1]];
            for (int a = 0; a < c - 1; ++a) {
                for (int b = a + 1; b < c; ++b) {
                    ans += counter[nums[a] + nums[b] + nums[c]];
                }
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
        Solution1995_2 _tcSol = new Solution1995_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,6]");
        try {
            int[] nums = new int[]{1, 2, 3, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.countQuadruplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,3,6,4,5]");
        try {
            int[] nums = new int[]{3, 3, 6, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.countQuadruplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,1,3,5]");
        try {
            int[] nums = new int[]{1, 1, 1, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.countQuadruplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}