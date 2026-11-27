package com.leetcode.arrays_hashing_greedy;

class Solution1122_2 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        int mi = 1001, mx = 0;
        for (int x : arr1) {
            ++cnt[x];
            mi = Math.min(mi, x);
            mx = Math.max(mx, x);
        }
        int m = arr1.length;
        int[] ans = new int[m];
        int i = 0;
        for (int x : arr2) {
            while (cnt[x] > 0) {
                --cnt[x];
                ans[i++] = x;
            }
        }
        for (int x = mi; x <= mx; ++x) {
            while (cnt[x] > 0) {
                --cnt[x];
                ans[i++] = x;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1122_2 _tcSol = new Solution1122_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]");
        try {
            int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
            int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.relativeSortArray(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2,2,1,4,3,3,9,6,7,19]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]");
        try {
            int[] arr1 = new int[]{28, 6, 22, 8, 44, 17};
            int[] arr2 = new int[]{22, 28, 8, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.relativeSortArray(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[22,28,8,6,17,44]");
        System.out.println();
    }
}
