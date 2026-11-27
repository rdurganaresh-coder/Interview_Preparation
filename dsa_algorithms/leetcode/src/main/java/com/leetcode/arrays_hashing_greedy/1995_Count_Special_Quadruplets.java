package com.leetcode.arrays_hashing_greedy;

class Solution1995 {
    public int countQuadruplets(int[] nums) {
        int ans = 0, n = nums.length;
        for (int a = 0; a < n - 3; ++a) {
            for (int b = a + 1; b < n - 2; ++b) {
                for (int c = b + 1; c < n - 1; ++c) {
                    for (int d = c + 1; d < n; ++d) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            ++ans;
                        }
                    }
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
        Solution1995 _tcSol = new Solution1995();
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