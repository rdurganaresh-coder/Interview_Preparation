package com.leetcode.dynamic_programming;

class Solution3424 {
    public long minCost(int[] arr, int[] brr, long k) {
        long c1 = calc(arr, brr);
        Arrays.sort(arr);
        Arrays.sort(brr);
        long c2 = calc(arr, brr) + k;
        return Math.min(c1, c2);
    }

    private long calc(int[] arr, int[] brr) {
        long ans = 0;
        for (int i = 0; i < arr.length; ++i) {
            ans += Math.abs(arr[i] - brr[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3424 _tcSol = new Solution3424();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [-7,9,5], brr = [7,-2,-5], k = 2");
        try {
            int[] arr = new int[]{-7, 9, 5};
            int[] brr = new int[]{7, -2, -5};
            long k = 2L;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(arr, brr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [2,1], brr = [2,1], k = 0");
        try {
            int[] arr = new int[]{2, 1};
            int[] brr = new int[]{2, 1};
            long k = 0L;
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(arr, brr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
