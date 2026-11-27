package com.leetcode.strings;

class Solution2375 {
    private boolean[] vis = new boolean[10];
    private StringBuilder t = new StringBuilder();
    private String p;
    private String ans;

    public String smallestNumber(String pattern) {
        p = pattern;
        dfs(0);
        return ans;
    }

    private void dfs(int u) {
        if (ans != null) {
            return;
        }
        if (u == p.length() + 1) {
            ans = t.toString();
            return;
        }
        for (int i = 1; i < 10; ++i) {
            if (!vis[i]) {
                if (u > 0 && p.charAt(u - 1) == 'I' && t.charAt(u - 1) - '0' >= i) {
                    continue;
                }
                if (u > 0 && p.charAt(u - 1) == 'D' && t.charAt(u - 1) - '0' <= i) {
                    continue;
                }
                vis[i] = true;
                t.append(i);
                dfs(u + 1);
                t.deleteCharAt(t.length() - 1);
                vis[i] = false;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2375 _tcSol = new Solution2375();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "pattern = \"IIIDIDDD\"");
        try {
            String pattern = "IIIDIDDD";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestNumber(pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"123549876\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "pattern = \"DDD\"");
        try {
            String pattern = "DDD";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestNumber(pattern)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"4321\"");
        System.out.println();
    }
}