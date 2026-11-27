package com.leetcode.arrays_hashing_greedy;

class Solution2345 {
    public int visibleMountains(int[][] peaks) {
        int n = peaks.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            int x = peaks[i][0], y = peaks[i][1];
            arr[i] = new int[] {x - y, x + y};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ans = 0;
        int cur = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int l = arr[i][0], r = arr[i][1];
            if (r <= cur) {
                continue;
            }
            cur = r;
            if (!(i < n - 1 && arr[i][0] == arr[i + 1][0] && arr[i][1] == arr[i + 1][1])) {
                ++ans;
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
        Solution2345 _tcSol = new Solution2345();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "peaks = [[2,2],[6,3],[5,4]]");
        try {
            int[][] peaks = new int[][]{new int[]{2, 2}, new int[]{6, 3}, new int[]{5, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.visibleMountains(peaks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "peaks = [[1,3],[1,3]]");
        try {
            int[][] peaks = new int[][]{new int[]{1, 3}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.visibleMountains(peaks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
