package com.leetcode.arrays_hashing_greedy;

class Solution3022 {
    public int minOrAfterOperations(int[] nums, int k) {
        int ans = 0, rans = 0;
        for (int i = 29; i >= 0; i--) {
            int test = ans + (1 << i);
            int cnt = 0;
            int val = 0;
            for (int num : nums) {
                if (val == 0) {
                    val = test & num;
                } else {
                    val &= test & num;
                }
                if (val != 0) {
                    cnt++;
                }
            }
            if (cnt > k) {
                rans += (1 << i);
            } else {
                ans += (1 << i);
            }
        }
        return rans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3022 _tcSol = new Solution3022();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,5,3,2,7], k = 2");
        try {
            int[] nums = new int[]{3, 5, 3, 2, 7};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOrAfterOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [7,3,15,14,2,8], k = 4");
        try {
            int[] nums = new int[]{7, 3, 15, 14, 2, 8};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOrAfterOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [10,7,10,3,9,14,9,4], k = 1");
        try {
            int[] nums = new int[]{10, 7, 10, 3, 9, 14, 9, 4};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOrAfterOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}
