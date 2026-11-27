package com.leetcode.arrays_hashing_greedy;

class Solution1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int w = books[i - 1][0], h = books[i - 1][1];
            f[i] = f[i - 1] + h;
            for (int j = i - 1; j > 0; --j) {
                w += books[j - 1][0];
                if (w > shelfWidth) {
                    break;
                }
                h = Math.max(h, books[j - 1][1]);
                f[i] = Math.min(f[i], f[j - 1] + h);
            }
        }
        return f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1105 _tcSol = new Solution1105();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelfWidth = 4");
        try {
            int[][] books = new int[][]{new int[]{1, 1}, new int[]{2, 3}, new int[]{2, 3}, new int[]{1, 1}, new int[]{1, 1}, new int[]{1, 1}, new int[]{1, 2}};
            int shelfWidth = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minHeightShelves(books, shelfWidth)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "books = [[1,3],[2,4],[3,2]], shelfWidth = 6");
        try {
            int[][] books = new int[][]{new int[]{1, 3}, new int[]{2, 4}, new int[]{3, 2}};
            int shelfWidth = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minHeightShelves(books, shelfWidth)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}