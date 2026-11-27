package com.leetcode.arrays_hashing_greedy;

class Solution2551 {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] arr = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            arr[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(arr);
        long ans = 0;
        for (int i = 0; i < k - 1; ++i) {
            ans -= arr[i];
            ans += arr[n - 2 - i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2551 _tcSol = new Solution2551();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "weights = [1,3,5,1], k = 2");
        try {
            int[] weights = new int[]{1, 3, 5, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.putMarbles(weights, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "weights = [1, 3], k = 2");
        try {
            int[] weights = new int[]{1, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.putMarbles(weights, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}