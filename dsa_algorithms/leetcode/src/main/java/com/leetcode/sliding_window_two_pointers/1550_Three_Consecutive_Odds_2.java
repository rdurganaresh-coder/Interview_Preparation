package com.leetcode.sliding_window_two_pointers;

class Solution1550_2 {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 2, n = arr.length; i < n; ++i) {
            if ((arr[i - 2] & arr[i - 1] & arr[i] & 1) == 1) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1550_2 _tcSol = new Solution1550_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [2,6,4,1]");
        try {
            int[] arr = new int[]{2, 6, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.threeConsecutiveOdds(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,2,34,3,4,5,7,23,12]");
        try {
            int[] arr = new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.threeConsecutiveOdds(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
