package com.leetcode.arrays_hashing_greedy;

class Solution3011 {
    public boolean canSortArray(int[] nums) {
        int preMx = 0;
        int i = 0, n = nums.length;
        while (i < n) {
            int cnt = Integer.bitCount(nums[i]);
            int j = i + 1;
            int mi = nums[i], mx = nums[i];
            while (j < n && Integer.bitCount(nums[j]) == cnt) {
                mi = Math.min(mi, nums[j]);
                mx = Math.max(mx, nums[j]);
                j++;
            }
            if (preMx > mi) {
                return false;
            }
            preMx = mx;
            i = j;
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3011 _tcSol = new Solution3011();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [8,4,2,30,15]");
        try {
            int[] nums = new int[]{8, 4, 2, 30, 15};
            System.out.println("  Output  : " + _tcShow(_tcSol.canSortArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.canSortArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,16,8,4,2]");
        try {
            int[] nums = new int[]{3, 16, 8, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.canSortArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}