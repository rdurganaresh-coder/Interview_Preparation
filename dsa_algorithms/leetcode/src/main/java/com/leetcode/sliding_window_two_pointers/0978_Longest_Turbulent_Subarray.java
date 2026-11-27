package com.leetcode.sliding_window_two_pointers;

class Solution0978 {
    public int maxTurbulenceSize(int[] arr) {
        int ans = 1, f = 1, g = 1;
        for (int i = 1; i < arr.length; ++i) {
            int ff = arr[i - 1] < arr[i] ? g + 1 : 1;
            int gg = arr[i - 1] > arr[i] ? f + 1 : 1;
            f = ff;
            g = gg;
            ans = Math.max(ans, Math.max(f, g));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0978 _tcSol = new Solution0978();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [9,4,2,10,7,8,8,1,9]");
        try {
            int[] arr = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTurbulenceSize(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [4,8,12,16]");
        try {
            int[] arr = new int[]{4, 8, 12, 16};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTurbulenceSize(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [100]");
        try {
            int[] arr = new int[]{100};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTurbulenceSize(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}