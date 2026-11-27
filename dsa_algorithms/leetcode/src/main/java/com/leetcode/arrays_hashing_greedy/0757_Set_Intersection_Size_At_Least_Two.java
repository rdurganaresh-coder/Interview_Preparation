package com.leetcode.arrays_hashing_greedy;

class Solution0757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int ans = 0;
        int s = -1, e = -1;
        for (int[] v : intervals) {
            int a = v[0], b = v[1];
            if (a <= s) {
                continue;
            }
            if (a > e) {
                ans += 2;
                s = b - 1;
                e = b;
            } else {
                ans += 1;
                s = e;
                e = b;
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
        Solution0757 _tcSol = new Solution0757();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "intervals = [[1,3],[3,7],[8,9]]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 3}, new int[]{3, 7}, new int[]{8, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.intersectionSizeTwo(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "intervals = [[1,3],[1,4],[2,5],[3,5]]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 5}, new int[]{3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.intersectionSizeTwo(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "intervals = [[1,2],[2,3],[2,4],[4,5]]");
        try {
            int[][] intervals = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{2, 4}, new int[]{4, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.intersectionSizeTwo(intervals)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}