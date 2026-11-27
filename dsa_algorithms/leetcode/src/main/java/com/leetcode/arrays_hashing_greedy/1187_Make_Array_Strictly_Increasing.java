package com.leetcode.arrays_hashing_greedy;

class Solution1187 {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int m = 0;
        for (int x : arr2) {
            if (m == 0 || x != arr2[m - 1]) {
                arr2[m++] = x;
            }
        }
        final int inf = 1 << 30;
        int[] arr = new int[arr1.length + 2];
        arr[0] = -inf;
        arr[arr.length - 1] = inf;
        System.arraycopy(arr1, 0, arr, 1, arr1.length);
        int[] f = new int[arr.length];
        Arrays.fill(f, inf);
        f[0] = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i - 1] < arr[i]) {
                f[i] = f[i - 1];
            }
            int j = search(arr2, arr[i], m);
            for (int k = 1; k <= Math.min(i - 1, j); ++k) {
                if (arr[i - k - 1] < arr2[j - k]) {
                    f[i] = Math.min(f[i], f[i - k - 1] + k);
                }
            }
        }
        return f[arr.length - 1] >= inf ? -1 : f[arr.length - 1];
    }

    private int search(int[] nums, int x, int n) {
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1187 _tcSol = new Solution1187();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]");
        try {
            int[] arr1 = new int[]{1, 5, 3, 6, 7};
            int[] arr2 = new int[]{1, 3, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeArrayIncreasing(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr1 = [1,5,3,6,7], arr2 = [4,3,1]");
        try {
            int[] arr1 = new int[]{1, 5, 3, 6, 7};
            int[] arr2 = new int[]{4, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeArrayIncreasing(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]");
        try {
            int[] arr1 = new int[]{1, 5, 3, 6, 7};
            int[] arr2 = new int[]{1, 6, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeArrayIncreasing(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}