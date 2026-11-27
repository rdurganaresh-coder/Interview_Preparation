package com.leetcode.arrays_hashing_greedy;

class Solution1131 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int[] dirs = {1, -1, -1, 1, 1};
        final int inf = 1 << 30;
        int ans = -inf;
        int n = arr1.length;
        for (int k = 0; k < 4; ++k) {
            int a = dirs[k], b = dirs[k + 1];
            int mx = -inf, mi = inf;
            for (int i = 0; i < n; ++i) {
                mx = Math.max(mx, a * arr1[i] + b * arr2[i] + i);
                mi = Math.min(mi, a * arr1[i] + b * arr2[i] + i);
                ans = Math.max(ans, mx - mi);
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
        Solution1131 _tcSol = new Solution1131();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr1 = [1,2,3,4], arr2 = [-1,4,5,6]");
        try {
            int[] arr1 = new int[]{1, 2, 3, 4};
            int[] arr2 = new int[]{-1, 4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAbsValExpr(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]");
        try {
            int[] arr1 = new int[]{1, -2, -5, 0, 10};
            int[] arr2 = new int[]{0, -2, -1, -7, -4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxAbsValExpr(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();
    }
}