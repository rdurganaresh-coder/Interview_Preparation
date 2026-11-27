package com.leetcode.arrays_hashing_greedy;

class Solution0260 {
    public int[] singleNumber(int[] nums) {
        int xs = 0;
        for (int x : nums) {
            xs ^= x;
        }
        int lb = xs & -xs;
        int a = 0;
        for (int x : nums) {
            if ((x & lb) != 0) {
                a ^= x;
            }
        }
        int b = xs ^ a;
        return new int[] {a, b};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0260 _tcSol = new Solution0260();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1,3,2,5]");
        try {
            int[] nums = new int[]{1, 2, 1, 3, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.singleNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,0]");
        try {
            int[] nums = new int[]{-1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.singleNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [0,1]");
        try {
            int[] nums = new int[]{0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.singleNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,0]");
        System.out.println();
    }
}