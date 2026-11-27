package com.leetcode.arrays_hashing_greedy;

class Solution1840 {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> r = new ArrayList<>();
        r.addAll(Arrays.asList(restrictions));
        r.add(new int[] {1, 0});
        Collections.sort(r, (a, b) -> a[0] - b[0]);
        if (r.get(r.size() - 1)[0] != n) {
            r.add(new int[] {n, n - 1});
        }
        int m = r.size();
        for (int i = 1; i < m; ++i) {
            int[] a = r.get(i - 1), b = r.get(i);
            b[1] = Math.min(b[1], a[1] + b[0] - a[0]);
        }
        for (int i = m - 2; i > 0; --i) {
            int[] a = r.get(i), b = r.get(i + 1);
            a[1] = Math.min(a[1], b[1] + b[0] - a[0]);
        }
        int ans = 0;
        for (int i = 0; i < m - 1; ++i) {
            int[] a = r.get(i), b = r.get(i + 1);
            int t = (a[1] + b[1] + b[0] - a[0]) / 2;
            ans = Math.max(ans, t);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1840 _tcSol = new Solution1840();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, restrictions = [[2,1],[4,1]]");
        try {
            int n = 5;
            int[][] restrictions = new int[][]{new int[]{2, 1}, new int[]{4, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxBuilding(n, restrictions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, restrictions = []");
        try {
            int n = 6;
            int[][] restrictions = new int[][]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxBuilding(n, restrictions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 10, restrictions = [[5,3],[2,5],[7,4],[10,3]]");
        try {
            int n = 10;
            int[][] restrictions = new int[][]{new int[]{5, 3}, new int[]{2, 5}, new int[]{7, 4}, new int[]{10, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxBuilding(n, restrictions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}