package com.leetcode.backtracking;

class Solution1409 {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> p = new LinkedList<>();
        for (int i = 1; i <= m; ++i) {
            p.add(i);
        }
        int[] ans = new int[queries.length];
        int i = 0;
        for (int v : queries) {
            int j = p.indexOf(v);
            ans[i++] = j;
            p.remove(j);
            p.add(0, v);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1409 _tcSol = new Solution1409();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "queries = [3,1,2,1], m = 5");
        try {
            int[] queries = new int[]{3, 1, 2, 1};
            int m = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.processQueries(queries, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1,2,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "queries = [4,1,2,2], m = 4");
        try {
            int[] queries = new int[]{4, 1, 2, 2};
            int m = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.processQueries(queries, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,1,2,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "queries = [7,5,5,8,3], m = 8");
        try {
            int[] queries = new int[]{7, 5, 5, 8, 3};
            int m = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.processQueries(queries, m)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,5,0,7,5]");
        System.out.println();
    }
}