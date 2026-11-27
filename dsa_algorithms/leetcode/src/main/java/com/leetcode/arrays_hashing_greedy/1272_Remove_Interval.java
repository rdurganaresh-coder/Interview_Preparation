package com.leetcode.arrays_hashing_greedy;

class Solution1272 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int x = toBeRemoved[0], y = toBeRemoved[1];
        List<List<Integer>> ans = new ArrayList<>();
        for (var e : intervals) {
            int a = e[0], b = e[1];
            if (a >= y || b <= x) {
                ans.add(Arrays.asList(a, b));
            } else {
                if (a < x) {
                    ans.add(Arrays.asList(a, x));
                }
                if (b > y) {
                    ans.add(Arrays.asList(y, b));
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
        Solution1272 _tcSol = new Solution1272();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]");
        try {
            int[][] intervals = new int[][]{new int[]{0, 2}, new int[]{3, 4}, new int[]{5, 7}};
            int[] toBeRemoved = new int[]{1, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeInterval(intervals, toBeRemoved)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,1],[6,7]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "intervals = [[0,5]], toBeRemoved = [2,3]");
        try {
            int[][] intervals = new int[][]{new int[]{0, 5}};
            int[] toBeRemoved = new int[]{2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeInterval(intervals, toBeRemoved)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,2],[3,5]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "intervals = [[-5,-4],[-3,-2],[1,2],[3,5],[8,9]], toBeRemoved = [-1,4]");
        try {
            int[][] intervals = new int[][]{new int[]{-5, -4}, new int[]{-3, -2}, new int[]{1, 2}, new int[]{3, 5}, new int[]{8, 9}};
            int[] toBeRemoved = new int[]{-1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.removeInterval(intervals, toBeRemoved)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[-5,-4],[-3,-2],[4,5],[8,9]]");
        System.out.println();
    }
}