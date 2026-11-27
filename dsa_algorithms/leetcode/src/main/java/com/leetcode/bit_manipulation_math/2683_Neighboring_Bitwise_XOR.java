package com.leetcode.bit_manipulation_math;

class Solution2683 {
    public boolean doesValidArrayExist(int[] derived) {
        int s = 0;
        for (int x : derived) {
            s ^= x;
        }
        return s == 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2683 _tcSol = new Solution2683();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "derived = [1,1,0]");
        try {
            int[] derived = new int[]{1, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.doesValidArrayExist(derived)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "derived = [1,1]");
        try {
            int[] derived = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.doesValidArrayExist(derived)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "derived = [1,0]");
        try {
            int[] derived = new int[]{1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.doesValidArrayExist(derived)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}