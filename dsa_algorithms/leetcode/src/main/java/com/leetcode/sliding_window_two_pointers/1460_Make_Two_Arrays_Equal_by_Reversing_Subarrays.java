package com.leetcode.sliding_window_two_pointers;

class Solution1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1460 _tcSol = new Solution1460();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = [1,2,3,4], arr = [2,4,1,3]");
        try {
            int[] target = new int[]{1, 2, 3, 4};
            int[] arr = new int[]{2, 4, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeEqual(target, arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = [7], arr = [7]");
        try {
            int[] target = new int[]{7};
            int[] arr = new int[]{7};
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeEqual(target, arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "target = [3,7,9], arr = [3,7,11]");
        try {
            int[] target = new int[]{3, 7, 9};
            int[] arr = new int[]{3, 7, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.canBeEqual(target, arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}