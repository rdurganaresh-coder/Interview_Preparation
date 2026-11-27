package com.leetcode.arrays_hashing_greedy;

class Solution1300 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] s = new int[n + 1];
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + arr[i];
            mx = Math.max(mx, arr[i]);
        }
        int ans = 0, diff = 1 << 30;
        for (int value = 0; value <= mx; ++value) {
            int i = search(arr, value);
            int d = Math.abs(s[i] + (n - i) * value - target);
            if (diff > d) {
                diff = d;
                ans = value;
            }
        }
        return ans;
    }

    private int search(int[] arr, int x) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > x) {
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
        Solution1300 _tcSol = new Solution1300();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [4,9,3], target = 10");
        try {
            int[] arr = new int[]{4, 9, 3};
            int target = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.findBestValue(arr, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [2,3,5], target = 10");
        try {
            int[] arr = new int[]{2, 3, 5};
            int target = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.findBestValue(arr, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [60864,25176,27249,21296,20204], target = 56803");
        try {
            int[] arr = new int[]{60864, 25176, 27249, 21296, 20204};
            int target = 56803;
            System.out.println("  Output  : " + _tcShow(_tcSol.findBestValue(arr, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11361");
        System.out.println();
    }
}