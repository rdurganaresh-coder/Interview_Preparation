package com.leetcode.arrays_hashing_greedy;

class Solution2772 {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] d = new int[n + 1];
        int s = 0;
        for (int i = 0; i < n; ++i) {
            s += d[i];
            nums[i] += s;
            if (nums[i] == 0) {
                continue;
            }
            if (nums[i] < 0 || i + k > n) {
                return false;
            }
            s -= nums[i];
            d[i + k] += nums[i];
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2772 _tcSol = new Solution2772();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,2,3,1,1,0], k = 3");
        try {
            int[] nums = new int[]{2, 2, 3, 1, 1, 0};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,1,1], k = 2");
        try {
            int[] nums = new int[]{1, 3, 1, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}