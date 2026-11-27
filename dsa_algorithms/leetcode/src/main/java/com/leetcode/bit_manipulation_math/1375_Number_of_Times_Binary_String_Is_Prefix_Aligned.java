package com.leetcode.bit_manipulation_math;

class Solution1375 {
    public int numTimesAllBlue(int[] flips) {
        int ans = 0, mx = 0;
        for (int i = 1; i <= flips.length; ++i) {
            mx = Math.max(mx, flips[i - 1]);
            if (mx == i) {
                ++ans;
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
        Solution1375 _tcSol = new Solution1375();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "flips = [3,2,4,1,5]");
        try {
            int[] flips = new int[]{3, 2, 4, 1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.numTimesAllBlue(flips)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "flips = [4,1,2,3]");
        try {
            int[] flips = new int[]{4, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.numTimesAllBlue(flips)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}