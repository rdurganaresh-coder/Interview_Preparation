package com.leetcode.sliding_window_two_pointers;

class Solution1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] ss = new int[n + 1][26];
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 26; ++j) {
                ss[i][j] = ss[i - 1][j];
            }
            ss[i][s.charAt(i - 1) - 'a']++;
        }
        List<Boolean> ans = new ArrayList<>();
        for (var q : queries) {
            int l = q[0], r = q[1], k = q[2];
            int x = 0;
            for (int j = 0; j < 26; ++j) {
                x += (ss[r + 1][j] - ss[l][j]) & 1;
            }
            ans.add(x / 2 <= k);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1177 _tcSol = new Solution1177();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcda\", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]");
        try {
            String s = "abcda";
            int[][] queries = new int[][]{new int[]{3, 3, 0}, new int[]{1, 2, 0}, new int[]{0, 3, 1}, new int[]{0, 3, 2}, new int[]{0, 4, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakePaliQueries(s, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,false,false,true,true]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"lyb\", queries = [[0,1,0],[2,2,1]]");
        try {
            String s = "lyb";
            int[][] queries = new int[][]{new int[]{0, 1, 0}, new int[]{2, 2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakePaliQueries(s, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,true]");
        System.out.println();
    }
}