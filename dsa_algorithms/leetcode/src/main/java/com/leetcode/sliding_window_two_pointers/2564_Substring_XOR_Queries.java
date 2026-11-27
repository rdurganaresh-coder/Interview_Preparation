package com.leetcode.sliding_window_two_pointers;

class Solution2564 {
    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer, int[]> d = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int x = 0;
            for (int j = 0; j < 32 && i + j < n; ++j) {
                x = x << 1 | (s.charAt(i + j) - '0');
                d.putIfAbsent(x, new int[] {i, i + j});
                if (x == 0) {
                    break;
                }
            }
        }
        int m = queries.length;
        int[][] ans = new int[m][2];
        for (int i = 0; i < m; ++i) {
            int first = queries[i][0], second = queries[i][1];
            int val = first ^ second;
            ans[i] = d.getOrDefault(val, new int[] {-1, -1});
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2564 _tcSol = new Solution2564();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"101101\", queries = [[0,5],[1,2]]");
        try {
            String s = "101101";
            int[][] queries = new int[][]{new int[]{0, 5}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.substringXorQueries(s, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,2],[2,3]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"0101\", queries = [[12,8]]");
        try {
            String s = "0101";
            int[][] queries = new int[][]{new int[]{12, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.substringXorQueries(s, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[-1,-1]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"1\", queries = [[4,5]]");
        try {
            String s = "1";
            int[][] queries = new int[][]{new int[]{4, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.substringXorQueries(s, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0]]");
        System.out.println();
    }
}