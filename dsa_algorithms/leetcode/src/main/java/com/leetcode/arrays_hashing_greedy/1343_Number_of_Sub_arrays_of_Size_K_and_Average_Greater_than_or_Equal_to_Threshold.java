package com.leetcode.arrays_hashing_greedy;

class Solution1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        threshold *= k;
        int s = 0;
        for (int i = 0; i < k; ++i) {
            s += arr[i];
        }
        int ans = s >= threshold ? 1 : 0;
        for (int i = k; i < arr.length; ++i) {
            s += arr[i] - arr[i - k];
            ans += s >= threshold ? 1 : 0;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1343 _tcSol = new Solution1343();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4");
        try {
            int[] arr = new int[]{2, 2, 2, 2, 5, 5, 5, 8};
            int k = 3;
            int threshold = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfSubarrays(arr, k, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5");
        try {
            int[] arr = new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
            int k = 3;
            int threshold = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfSubarrays(arr, k, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}