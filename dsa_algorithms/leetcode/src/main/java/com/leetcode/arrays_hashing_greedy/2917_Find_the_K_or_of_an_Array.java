package com.leetcode.arrays_hashing_greedy;

class Solution2917 {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int cnt = 0;
            for (int x : nums) {
                cnt += (x >> i & 1);
            }
            if (cnt >= k) {
                ans |= 1 << i;
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
        Solution2917 _tcSol = new Solution2917();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [7,12,9,8,9,15], k = 4");
        try {
            int[] nums = new int[]{7, 12, 9, 8, 9, 15};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKOr(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,12,1,11,4,5], k = 6");
        try {
            int[] nums = new int[]{2, 12, 1, 11, 4, 5};
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKOr(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [10,8,5,9,11,6,8], k = 1");
        try {
            int[] nums = new int[]{10, 8, 5, 9, 11, 6, 8};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKOr(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}