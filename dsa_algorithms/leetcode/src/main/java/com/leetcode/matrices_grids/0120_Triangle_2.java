package com.leetcode.matrices_grids;

class Solution0120_2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                f[j] = Math.min(f[j], f[j + 1]) + triangle.get(i).get(j);
            }
        }
        return f[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution0120_2 _tcSol = new Solution0120_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]");
        try {
            List<List<Integer>> triangle = _tcL(_tcL(2), _tcL(3, 4), _tcL(6, 5, 7), _tcL(4, 1, 8, 3));
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTotal(triangle)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "triangle = [[-10]]");
        try {
            List<List<Integer>> triangle = _tcL(_tcL(-10));
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTotal(triangle)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-10");
        System.out.println();
    }
}
