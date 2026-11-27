package com.leetcode.backtracking;

class Solution1053 {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i > 0; --i) {
            if (arr[i - 1] > arr[i]) {
                for (int j = n - 1; j > i - 1; --j) {
                    if (arr[j] < arr[i - 1] && arr[j] != arr[j - 1]) {
                        int t = arr[i - 1];
                        arr[i - 1] = arr[j];
                        arr[j] = t;
                        return arr;
                    }
                }
            }
        }
        return arr;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1053 _tcSol = new Solution1053();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [3,2,1]");
        try {
            int[] arr = new int[]{3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.prevPermOpt1(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,1,5]");
        try {
            int[] arr = new int[]{1, 1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.prevPermOpt1(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,5]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [1,9,4,6,7]");
        try {
            int[] arr = new int[]{1, 9, 4, 6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.prevPermOpt1(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,7,4,6,9]");
        System.out.println();
    }
}