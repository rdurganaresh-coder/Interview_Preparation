package com.leetcode.arrays_hashing_greedy;

class Solution0436 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] arr = new int[n][0];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {intervals[i][0], i};
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int j = search(arr, intervals[i][1]);
            ans[i] = j < n ? arr[j][1] : -1;
        }
        return ans;
    }

    private int search(int[][] arr, int x) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid][0] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0436 _tcSol = new Solution0436();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "intervals = [[1,2]]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRightInterval(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "intervals = [[3,4],[2,3],[1,2]]");
        try {
            int[][] intervals = new int[][]{new int[]{3, 4}, new int[]{2, 3}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRightInterval(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,0,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "intervals = [[1,4],[2,3],[3,4]]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 4}, new int[]{2, 3}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRightInterval(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,2,-1]");
        System.out.println();
    }
}