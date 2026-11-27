package com.leetcode.arrays_hashing_greedy;

class Solution1562_2 {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n) {
            return n;
        }
        int[] cnt = new int[n + 2];
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            int v = arr[i];
            int l = cnt[v - 1], r = cnt[v + 1];
            if (l == m || r == m) {
                ans = i;
            }
            cnt[v - l] = l + r + 1;
            cnt[v + r] = l + r + 1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1562_2 _tcSol = new Solution1562_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [3,5,1,2,4], m = 1");
        try {
            int[] arr = new int[]{3, 5, 1, 2, 4};
            int m = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findLatestStep(arr, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [3,1,5,4,2], m = 2");
        try {
            int[] arr = new int[]{3, 1, 5, 4, 2};
            int m = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findLatestStep(arr, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}