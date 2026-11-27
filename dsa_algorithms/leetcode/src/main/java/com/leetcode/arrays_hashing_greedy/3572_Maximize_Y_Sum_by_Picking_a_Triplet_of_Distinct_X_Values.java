package com.leetcode.arrays_hashing_greedy;

class Solution3572 {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;
        int[][] arr = new int[n][0];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] {x[i], y[i]};
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        int ans = 0;
        Set<Integer> vis = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            int a = arr[i][0], b = arr[i][1];
            if (vis.add(a)) {
                ans += b;
                if (vis.size() == 3) {
                    return ans;
                }
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3572 _tcSol = new Solution3572();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = [1,2,1,3,2], y = [5,3,4,6,2]");
        try {
            int[] x = new int[]{1, 2, 1, 3, 2};
            int[] y = new int[]{5, 3, 4, 6, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumDistinctTriplet(x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = [1,2,1,2], y = [4,5,6,7]");
        try {
            int[] x = new int[]{1, 2, 1, 2};
            int[] y = new int[]{4, 5, 6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSumDistinctTriplet(x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}