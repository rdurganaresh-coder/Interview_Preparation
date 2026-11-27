package com.leetcode.arrays_hashing_greedy;

class Solution0137_2 {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int c : nums) {
            int aa = (~a & b & c) | (a & ~b & ~c);
            int bb = ~a & (b ^ c);
            a = aa;
            b = bb;
        }
        return b;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0137_2 _tcSol = new Solution0137_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,2,3,2]");
        try {
            int[] nums = new int[]{2, 2, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.singleNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,0,1,0,1,99]");
        try {
            int[] nums = new int[]{0, 1, 0, 1, 0, 1, 99};
            System.out.println("  Output  : " + _tcShow(_tcSol.singleNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "99");
        System.out.println();
    }
}