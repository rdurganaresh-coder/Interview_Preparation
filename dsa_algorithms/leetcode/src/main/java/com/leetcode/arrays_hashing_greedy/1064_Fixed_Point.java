package com.leetcode.arrays_hashing_greedy;

class Solution1064 {
    public int fixedPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] >= mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left] == left ? left : -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1064 _tcSol = new Solution1064();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [-10,-5,0,3,7]");
        try {
            int[] arr = new int[]{-10, -5, 0, 3, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.fixedPoint(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [0,2,5,8,17]");
        try {
            int[] arr = new int[]{0, 2, 5, 8, 17};
            System.out.println("  Output  : " + _tcShow(_tcSol.fixedPoint(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [-10,-5,3,4,7,9]");
        try {
            int[] arr = new int[]{-10, -5, 3, 4, 7, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.fixedPoint(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}