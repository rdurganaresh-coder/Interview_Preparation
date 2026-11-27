package com.leetcode.arrays_hashing_greedy;

class Solution0646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0, pre = Integer.MIN_VALUE;
        for (var p : pairs) {
            if (pre < p[0]) {
                ++ans;
                pre = p[1];
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
        Solution0646 _tcSol = new Solution0646();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "pairs = [[1,2],[2,3],[3,4]]");
        try {
            int[][] pairs = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLongestChain(pairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "pairs = [[1,2],[7,8],[4,5]]");
        try {
            int[][] pairs = new int[][]{new int[]{1, 2}, new int[]{7, 8}, new int[]{4, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLongestChain(pairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
