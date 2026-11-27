package com.leetcode.arrays_hashing_greedy;

class Solution2655 {
    public int[][] findMaximalUncoveredRanges(int n, int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int last = -1;
        List<int[]> ans = new ArrayList<>();
        for (int[] range : ranges) {
            int l = range[0], r = range[1];
            if (last + 1 < l) {
                ans.add(new int[] {last + 1, l - 1});
            }
            last = Math.max(last, r);
        }
        if (last + 1 < n) {
            ans.add(new int[] {last + 1, n - 1});
        }
        return ans.toArray(new int[0][]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2655 _tcSol = new Solution2655();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 10, ranges = [[3,5],[7,8]]");
        try {
            int n = 10;
            int[][] ranges = new int[][]{new int[]{3, 5}, new int[]{7, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaximalUncoveredRanges(n, ranges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,2],[6,6],[9,9]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, ranges = [[0,2]]");
        try {
            int n = 3;
            int[][] ranges = new int[][]{new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaximalUncoveredRanges(n, ranges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 7, ranges = [[2,4],[0,3]]");
        try {
            int n = 7;
            int[][] ranges = new int[][]{new int[]{2, 4}, new int[]{0, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaximalUncoveredRanges(n, ranges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[5,6]]");
        System.out.println();
    }
}