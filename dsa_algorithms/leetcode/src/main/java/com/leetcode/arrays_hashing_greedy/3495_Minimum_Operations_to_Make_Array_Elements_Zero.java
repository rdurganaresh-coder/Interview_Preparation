package com.leetcode.arrays_hashing_greedy;

class Solution3495 {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            long s = f(r) - f(l - 1);
            long mx = f(r) - f(r - 1);
            ans += Math.max((s + 1) / 2, mx);
        }
        return ans;
    }

    private long f(long x) {
        long res = 0;
        long p = 1;
        int i = 1;
        while (p <= x) {
            long cnt = Math.min(p * 4 - 1, x) - p + 1;
            res += cnt * i;
            i++;
            p *= 4;
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3495 _tcSol = new Solution3495();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "queries = [[1,2],[2,4]]");
        try {
            int[][] queries = new int[][]{new int[]{1, 2}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "queries = [[2,6]]");
        try {
            int[][] queries = new int[][]{new int[]{2, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
