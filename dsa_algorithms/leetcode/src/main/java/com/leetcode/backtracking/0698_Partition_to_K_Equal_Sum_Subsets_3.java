package com.leetcode.backtracking;

class Solution0698_3 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        if (s % k != 0) {
            return false;
        }
        s /= k;
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] f = new boolean[1 << n];
        f[0] = true;
        int[] cur = new int[1 << n];
        for (int i = 0; i < 1 << n; ++i) {
            if (!f[i]) {
                continue;
            }
            for (int j = 0; j < n; ++j) {
                if (cur[i] + nums[j] > s) {
                    break;
                }
                if ((i >> j & 1) == 0) {
                    cur[i | 1 << j] = (cur[i] + nums[j]) % s;
                    f[i | 1 << j] = true;
                }
            }
        }
        return f[(1 << n) - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0698_3 _tcSol = new Solution0698_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,3,2,3,5,2,1], k = 4");
        try {
            int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.canPartitionKSubsets(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4], k = 3");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.canPartitionKSubsets(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}