package com.leetcode.arrays_hashing_greedy;

class Solution1539 {
    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] - mid - 1 >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left - 1] + k - (arr[left - 1] - (left - 1) - 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1539 _tcSol = new Solution1539();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [2,3,4,7,11], k = 5");
        try {
            int[] arr = new int[]{2, 3, 4, 7, 11};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKthPositive(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,2,3,4], k = 2");
        try {
            int[] arr = new int[]{1, 2, 3, 4};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKthPositive(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}