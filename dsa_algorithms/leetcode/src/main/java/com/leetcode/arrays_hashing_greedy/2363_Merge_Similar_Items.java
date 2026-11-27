package com.leetcode.arrays_hashing_greedy;

class Solution2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] cnt = new int[1010];
        for (var x : items1) {
            cnt[x[0]] += x[1];
        }
        for (var x : items2) {
            cnt[x[0]] += x[1];
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                ans.add(List.of(i, cnt[i]));
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
        Solution2363 _tcSol = new Solution2363();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]");
        try {
            int[][] items1 = new int[][]{new int[]{1, 1}, new int[]{4, 5}, new int[]{3, 8}};
            int[][] items2 = new int[][]{new int[]{3, 1}, new int[]{1, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeSimilarItems(items1, items2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,6],[3,9],[4,5]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "items1 = [[1,1],[3,2],[2,3]], items2 = [[2,1],[3,2],[1,3]]");
        try {
            int[][] items1 = new int[][]{new int[]{1, 1}, new int[]{3, 2}, new int[]{2, 3}};
            int[][] items2 = new int[][]{new int[]{2, 1}, new int[]{3, 2}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeSimilarItems(items1, items2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,4],[2,4],[3,4]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "items1 = [[1,3],[2,2]], items2 = [[7,1],[2,2],[1,4]]");
        try {
            int[][] items1 = new int[][]{new int[]{1, 3}, new int[]{2, 2}};
            int[][] items2 = new int[][]{new int[]{7, 1}, new int[]{2, 2}, new int[]{1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.mergeSimilarItems(items1, items2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,7],[2,4],[7,1]]");
        System.out.println();
    }
}