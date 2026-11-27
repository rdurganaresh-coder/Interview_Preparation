package com.leetcode.dynamic_programming;

class Solution0522 {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        int n = strs.length;
        for (int i = 0, j; i < n; ++i) {
            int x = strs[i].length();
            for (j = 0; j < n; ++j) {
                if (i != j && check(strs[i], strs[j])) {
                    x = -1;
                    break;
                }
            }
            ans = Math.max(ans, x);
        }
        return ans;
    }

    private boolean check(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0;
        for (int j = 0; i < m && j < n; ++j) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
            }
        }
        return i == m;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0522 _tcSol = new Solution0522();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "strs = [\"aba\",\"cdc\",\"eae\"]");
        try {
            String[] strs = new String[]{"aba", "cdc", "eae"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLUSlength(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "strs = [\"aaa\",\"aaa\",\"aa\"]");
        try {
            String[] strs = new String[]{"aaa", "aaa", "aa"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLUSlength(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}