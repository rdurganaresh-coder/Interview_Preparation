package com.leetcode.arrays_hashing_greedy;

class Solution1477 {
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> d = new HashMap<>();
        d.put(0, 0);
        int n = arr.length;
        int[] f = new int[n + 1];
        final int inf = 1 << 30;
        f[0] = inf;
        int s = 0, ans = inf;
        for (int i = 1; i <= n; ++i) {
            int v = arr[i - 1];
            s += v;
            f[i] = f[i - 1];
            if (d.containsKey(s - target)) {
                int j = d.get(s - target);
                f[i] = Math.min(f[i], i - j);
                ans = Math.min(ans, f[j] + i - j);
            }
            d.put(s, i);
        }
        return ans > n ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1477 _tcSol = new Solution1477();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [3,2,2,4,3], target = 3");
        try {
            int[] arr = new int[]{3, 2, 2, 4, 3};
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSumOfLengths(arr, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [7,3,4,7], target = 7");
        try {
            int[] arr = new int[]{7, 3, 4, 7};
            int target = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSumOfLengths(arr, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [4,3,2,6,2,3,4], target = 6");
        try {
            int[] arr = new int[]{4, 3, 2, 6, 2, 3, 4};
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSumOfLengths(arr, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}