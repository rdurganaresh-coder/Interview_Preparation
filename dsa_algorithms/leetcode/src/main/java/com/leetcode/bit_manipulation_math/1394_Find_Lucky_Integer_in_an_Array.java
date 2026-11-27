package com.leetcode.bit_manipulation_math;

class Solution1394 {
    public int findLucky(int[] arr) {
        int[] cnt = new int[501];
        for (int x : arr) {
            ++cnt[x];
        }
        for (int x = cnt.length - 1; x > 0; --x) {
            if (x == cnt[x]) {
                return x;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1394 _tcSol = new Solution1394();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [2,2,3,4]");
        try {
            int[] arr = new int[]{2, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLucky(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,2,2,3,3,3]");
        try {
            int[] arr = new int[]{1, 2, 2, 3, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLucky(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [2,2,2,3,3]");
        try {
            int[] arr = new int[]{2, 2, 2, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLucky(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}