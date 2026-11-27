package com.leetcode.arrays_hashing_greedy;

class Solution0845 {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] f = new int[n];
        int[] g = new int[n];
        Arrays.fill(f, 1);
        Arrays.fill(g, 1);
        for (int i = 1; i < n; ++i) {
            if (arr[i] > arr[i - 1]) {
                f[i] = f[i - 1] + 1;
            }
        }
        int ans = 0;
        for (int i = n - 2; i >= 0; --i) {
            if (arr[i] > arr[i + 1]) {
                g[i] = g[i + 1] + 1;
                if (f[i] > 1) {
                    ans = Math.max(ans, f[i] + g[i] - 1);
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
        Solution0845 _tcSol = new Solution0845();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [2,1,4,7,3,2,5]");
        try {
            int[] arr = new int[]{2, 1, 4, 7, 3, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestMountain(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [2,2,2]");
        try {
            int[] arr = new int[]{2, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestMountain(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}