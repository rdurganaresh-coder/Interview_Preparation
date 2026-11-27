package com.leetcode.arrays_hashing_greedy;

class Solution0986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int m = firstList.length, n = secondList.length;
        for (int i = 0, j = 0; i < m && j < n;) {
            int l = Math.max(firstList[i][0], secondList[j][0]);
            int r = Math.min(firstList[i][1], secondList[j][1]);
            if (l <= r) {
                ans.add(new int[] {l, r});
            }
            if (firstList[i][1] < secondList[j][1]) {
                ++i;
            } else {
                ++j;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0986 _tcSol = new Solution0986();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]");
        try {
            int[][] firstList = new int[][]{new int[]{0, 2}, new int[]{5, 10}, new int[]{13, 23}, new int[]{24, 25}};
            int[][] secondList = new int[][]{new int[]{1, 5}, new int[]{8, 12}, new int[]{15, 24}, new int[]{25, 26}};
            System.out.println("  Output  : " + _tcShow(_tcSol.intervalIntersection(firstList, secondList)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "firstList = [[1,3],[5,9]], secondList = []");
        try {
            int[][] firstList = new int[][]{new int[]{1, 3}, new int[]{5, 9}};
            int[][] secondList = new int[][]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.intervalIntersection(firstList, secondList)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}