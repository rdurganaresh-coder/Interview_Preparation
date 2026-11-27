package com.leetcode.sliding_window_two_pointers;

class Solution2955 {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int n = s.length();
        int[][] cnt = new int[26][n + 1];
        for (int j = 1; j <= n; ++j) {
            for (int i = 0; i < 26; ++i) {
                cnt[i][j] = cnt[i][j - 1];
            }
            cnt[s.charAt(j - 1) - 'a'][j]++;
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int k = 0; k < m; ++k) {
            int l = queries[k][0], r = queries[k][1];
            ans[k] = r - l + 1;
            for (int i = 0; i < 26; ++i) {
                int x = cnt[i][r + 1] - cnt[i][l];
                ans[k] += x * (x - 1) / 2;
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
        Solution2955 _tcSol = new Solution2955();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcaab\", queries = [[0,0],[1,4],[2,5],[0,5]]");
        try {
            String s = "abcaab";
            int[][] queries = new int[][]{new int[]{0, 0}, new int[]{1, 4}, new int[]{2, 5}, new int[]{0, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sameEndSubstringCount(s, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,5,5,10]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcd\", queries = [[0,3]]");
        try {
            String s = "abcd";
            int[][] queries = new int[][]{new int[]{0, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.sameEndSubstringCount(s, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4]");
        System.out.println();
    }
}