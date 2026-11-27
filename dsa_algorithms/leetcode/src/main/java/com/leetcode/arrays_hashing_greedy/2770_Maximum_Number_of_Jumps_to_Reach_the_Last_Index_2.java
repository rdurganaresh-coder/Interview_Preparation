package com.leetcode.arrays_hashing_greedy;

class Solution2770_2 {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f, -(1 << 30));
        f[n - 1] = 0;
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (Math.abs(nums[i] - nums[j]) <= target) {
                    f[i] = Math.max(f[i], 1 + f[j]);
                }
            }
        }
        return f[0] < 0 ? -1 : f[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2770_2 _tcSol = new Solution2770_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,6,4,1,2], target = 2");
        try {
            int[] nums = new int[]{1, 3, 6, 4, 1, 2};
            int target = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumJumps(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,6,4,1,2], target = 3");
        try {
            int[] nums = new int[]{1, 3, 6, 4, 1, 2};
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumJumps(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,3,6,4,1,2], target = 0");
        try {
            int[] nums = new int[]{1, 3, 6, 4, 1, 2};
            int target = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumJumps(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
