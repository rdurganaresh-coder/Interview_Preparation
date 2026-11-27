package com.leetcode.binary_search;

class Solution1439 {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        List<Integer> pre = new ArrayList<>(k);
        List<Integer> cur = new ArrayList<>(n * k);
        pre.add(0);
        for (int[] row : mat) {
            cur.clear();
            for (int a : pre) {
                for (int b : row) {
                    cur.add(a + b);
                }
            }
            Collections.sort(cur);
            pre.clear();
            for (int i = 0; i < Math.min(k, cur.size()); ++i) {
                pre.add(cur.get(i));
            }
        }
        return pre.get(k - 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1439 _tcSol = new Solution1439();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,3,11],[2,4,6]], k = 5");
        try {
            int[][] mat = new int[][]{new int[]{1, 3, 11}, new int[]{2, 4, 6}};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallest(mat, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[1,3,11],[2,4,6]], k = 9");
        try {
            int[][] mat = new int[][]{new int[]{1, 3, 11}, new int[]{2, 4, 6}};
            int k = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallest(mat, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7");
        try {
            int[][] mat = new int[][]{new int[]{1, 10, 10}, new int[]{1, 4, 5}, new int[]{2, 3, 6}};
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallest(mat, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}