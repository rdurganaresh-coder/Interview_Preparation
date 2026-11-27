package com.leetcode.sliding_window_two_pointers;

class Solution1186 {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = -(1 << 30);
        for (int i = 0, s = 0; i < n; ++i) {
            s = Math.max(s, 0) + arr[i];
            left[i] = s;
            ans = Math.max(ans, left[i]);
        }
        for (int i = n - 1, s = 0; i >= 0; --i) {
            s = Math.max(s, 0) + arr[i];
            right[i] = s;
        }
        for (int i = 1; i < n - 1; ++i) {
            ans = Math.max(ans, left[i - 1] + right[i + 1]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1186 _tcSol = new Solution1186();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,-2,0,3]");
        try {
            int[] arr = new int[]{1, -2, 0, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSum(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,-2,-2,3]");
        try {
            int[] arr = new int[]{1, -2, -2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSum(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [-1,-1,-1,-1]");
        try {
            int[] arr = new int[]{-1, -1, -1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSum(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}