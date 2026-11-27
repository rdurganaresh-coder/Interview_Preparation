package com.leetcode.sliding_window_two_pointers;

class Solution0923 {
    public int threeSumMulti(int[] arr, int target) {
        final int mod = (int) 1e9 + 7;
        int[] cnt = new int[101];
        for (int x : arr) {
            ++cnt[x];
        }
        int n = arr.length;
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            --cnt[arr[j]];
            for (int i = 0; i < j; ++i) {
                int c = target - arr[i] - arr[j];
                if (c >= 0 && c < cnt.length) {
                    ans = (ans + cnt[c]) % mod;
                }
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
        Solution0923 _tcSol = new Solution0923();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,1,2,2,3,3,4,4,5,5], target = 8");
        try {
            int[] arr = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
            int target = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.threeSumMulti(arr, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,1,2,2,2,2], target = 5");
        try {
            int[] arr = new int[]{1, 1, 2, 2, 2, 2};
            int target = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.threeSumMulti(arr, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [2,1,3], target = 6");
        try {
            int[] arr = new int[]{2, 1, 3};
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.threeSumMulti(arr, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}