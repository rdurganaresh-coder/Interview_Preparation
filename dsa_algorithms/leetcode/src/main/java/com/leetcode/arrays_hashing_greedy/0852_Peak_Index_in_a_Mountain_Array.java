package com.leetcode.arrays_hashing_greedy;

class Solution0852 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 2;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0852 _tcSol = new Solution0852();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [0,1,0]");
        try {
            int[] arr = new int[]{0, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.peakIndexInMountainArray(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [0,2,1,0]");
        try {
            int[] arr = new int[]{0, 2, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.peakIndexInMountainArray(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [0,10,5,2]");
        try {
            int[] arr = new int[]{0, 10, 5, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.peakIndexInMountainArray(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}