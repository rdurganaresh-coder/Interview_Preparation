package com.leetcode.dynamic_programming;

class Solution2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] f = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            List<Integer> nums = piles.get(i - 1);
            int[] s = new int[nums.size() + 1];
            s[0] = 0;
            for (int j = 1; j <= nums.size(); j++) {
                s[j] = s[j - 1] + nums.get(j - 1);
            }
            for (int j = 0; j <= k; j++) {
                for (int h = 0; h < s.length && h <= j; h++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - h] + s[h]);
                }
            }
        }
        return f[n][k];
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
        Solution2218 _tcSol = new Solution2218();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "piles = [[1,100,3],[7,8,9]], k = 2");
        try {
            List<List<Integer>> piles = _tcL(_tcL(1, 100, 3), _tcL(7, 8, 9));
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxValueOfCoins(piles, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "101");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "piles = [[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]], k = 7");
        try {
            List<List<Integer>> piles = _tcL(_tcL(100), _tcL(100), _tcL(100), _tcL(100), _tcL(100), _tcL(100), _tcL(1, 1, 1, 1, 1, 1, 700));
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxValueOfCoins(piles, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "706");
        System.out.println();
    }
}
