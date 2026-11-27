package com.leetcode.dynamic_programming;

class Solution0873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] f = new int[n][n];
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            d.put(arr[i], i);
            for (int j = 0; j < i; ++j) {
                f[i][j] = 2;
            }
        }
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            for (int j = 1; j < i; ++j) {
                int t = arr[i] - arr[j];
                Integer k = d.get(t);
                if (k != null && k < j) {
                    f[i][j] = Math.max(f[i][j], f[j][k] + 1);
                    ans = Math.max(ans, f[i][j]);
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
        Solution0873 _tcSol = new Solution0873();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,2,3,4,5,6,7,8]");
        try {
            int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.lenLongestFibSubseq(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,3,7,11,12,14,18]");
        try {
            int[] arr = new int[]{1, 3, 7, 11, 12, 14, 18};
            System.out.println("  Output  : " + _tcShow(_tcSol.lenLongestFibSubseq(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}