package com.leetcode.binary_search;

class Solution2343 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        String[][] t = new String[n][2];
        for (int i = 0; i < m; ++i) {
            int k = queries[i][0], trim = queries[i][1];
            for (int j = 0; j < n; ++j) {
                t[j] = new String[] {nums[j].substring(nums[j].length() - trim), String.valueOf(j)};
            }
            Arrays.sort(t, (a, b) -> {
                int x = a[0].compareTo(b[0]);
                return x == 0 ? Long.compare(Integer.valueOf(a[1]), Integer.valueOf(b[1])) : x;
            });
            ans[i] = Integer.valueOf(t[k - 1][1]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2343 _tcSol = new Solution2343();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [\"102\",\"473\",\"251\",\"814\"], queries = [[1,1],[2,3],[4,2],[1,2]]");
        try {
            String[] nums = new String[]{"102", "473", "251", "814"};
            int[][] queries = new int[][]{new int[]{1, 1}, new int[]{2, 3}, new int[]{4, 2}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestTrimmedNumbers(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2,1,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [\"24\",\"37\",\"96\",\"04\"], queries = [[2,1],[2,2]]");
        try {
            String[] nums = new String[]{"24", "37", "96", "04"};
            int[][] queries = new int[][]{new int[]{2, 1}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestTrimmedNumbers(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,0]");
        System.out.println();
    }
}