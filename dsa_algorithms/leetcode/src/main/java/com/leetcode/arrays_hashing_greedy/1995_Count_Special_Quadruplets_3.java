package com.leetcode.arrays_hashing_greedy;

class Solution1995_3 {
    public int countQuadruplets(int[] nums) {
        int ans = 0, n = nums.length;
        int[] counter = new int[310];
        for (int b = n - 3; b > 0; --b) {
            int c = b + 1;
            for (int d = c + 1; d < n; ++d) {
                if (nums[d] - nums[c] >= 0) {
                    ++counter[nums[d] - nums[c]];
                }
            }
            for (int a = 0; a < b; ++a) {
                ans += counter[nums[a] + nums[b]];
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
        Solution1995_3 _tcSol = new Solution1995_3();
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