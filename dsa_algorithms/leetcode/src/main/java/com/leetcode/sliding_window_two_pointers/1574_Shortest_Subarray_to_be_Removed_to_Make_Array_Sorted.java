package com.leetcode.sliding_window_two_pointers;

class Solution1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i + 1 < n && arr[i] <= arr[i + 1]) {
            ++i;
        }
        while (j - 1 >= 0 && arr[j - 1] <= arr[j]) {
            --j;
        }
        if (i >= j) {
            return 0;
        }
        int ans = Math.min(n - i - 1, j);
        for (int l = 0; l <= i; ++l) {
            int r = search(arr, arr[l], j);
            ans = Math.min(ans, r - l - 1);
        }
        return ans;
    }

    private int search(int[] arr, int x, int left) {
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] >= x) {
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
        Solution1574 _tcSol = new Solution1574();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,2,3,10,4,2,3,5]");
        try {
            int[] arr = new int[]{1, 2, 3, 10, 4, 2, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLengthOfShortestSubarray(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [5,4,3,2,1]");
        try {
            int[] arr = new int[]{5, 4, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLengthOfShortestSubarray(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [1,2,3]");
        try {
            int[] arr = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLengthOfShortestSubarray(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}