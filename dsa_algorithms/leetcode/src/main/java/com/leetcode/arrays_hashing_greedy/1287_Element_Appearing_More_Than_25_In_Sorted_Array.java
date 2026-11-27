package com.leetcode.arrays_hashing_greedy;

class Solution1287 {
    public int findSpecialInteger(int[] arr) {
        for (int i = 0;; ++i) {
            if (arr[i] == (arr[i + (arr.length >> 2)])) {
                return arr[i];
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1287 _tcSol = new Solution1287();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,2,2,6,6,6,6,7,10]");
        try {
            int[] arr = new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.findSpecialInteger(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,1]");
        try {
            int[] arr = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findSpecialInteger(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
