package com.leetcode.bit_manipulation_math;

class Solution0717 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0, n = bits.length;
        while (i < n - 1) {
            i += bits[i] + 1;
        }
        return i == n - 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0717 _tcSol = new Solution0717();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "bits = [1,0,0]");
        try {
            int[] bits = new int[]{1, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.isOneBitCharacter(bits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "bits = [1,1,1,0]");
        try {
            int[] bits = new int[]{1, 1, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.isOneBitCharacter(bits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}