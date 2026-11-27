package com.leetcode.arrays_hashing_greedy;

class Solution1743_2 {
    private Map<Integer, List<Integer>> g = new HashMap<>();
    private int[] ans;

    public int[] restoreArray(int[][] adjacentPairs) {
        for (var e : adjacentPairs) {
            int a = e[0], b = e[1];
            g.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            g.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        int n = adjacentPairs.length + 1;
        ans = new int[n];
        for (var e : g.entrySet()) {
            if (e.getValue().size() == 1) {
                dfs(e.getKey(), 1000000, 0);
                break;
            }
        }
        return ans;
    }

    private void dfs(int i, int fa, int k) {
        ans[k++] = i;
        for (int j : g.get(i)) {
            if (j != fa) {
                dfs(j, i, k);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1743_2 _tcSol = new Solution1743_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "adjacentPairs = [[2,1],[3,4],[3,2]]");
        try {
            int[][] adjacentPairs = new int[][]{new int[]{2, 1}, new int[]{3, 4}, new int[]{3, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.restoreArray(adjacentPairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "adjacentPairs = [[4,-2],[1,4],[-3,1]]");
        try {
            int[][] adjacentPairs = new int[][]{new int[]{4, -2}, new int[]{1, 4}, new int[]{-3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.restoreArray(adjacentPairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-2,4,1,-3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "adjacentPairs = [[100000,-100000]]");
        try {
            int[][] adjacentPairs = new int[][]{new int[]{100000, -100000}};
            System.out.println("  Output  : " + _tcShow(_tcSol.restoreArray(adjacentPairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[100000,-100000]");
        System.out.println();
    }
}