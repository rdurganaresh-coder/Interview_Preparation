package com.leetcode.strings;

class Solution0097 {
    private Map<List<Integer>, Boolean> f = new HashMap<>();
    private String s1;
    private String s2;
    private String s3;
    private int m;
    private int n;

    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (i >= m && j >= n) {
            return true;
        }
        var key = List.of(i, j);
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int k = i + j;
        boolean ans = false;
        if (i < m && s1.charAt(i) == s3.charAt(k) && dfs(i + 1, j)) {
            ans = true;
        }
        if (!ans && j < n && s2.charAt(j) == s3.charAt(k) && dfs(i, j + 1)) {
            ans = true;
        }
        f.put(key, ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0097 _tcSol = new Solution0097();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"aabcc\", s2 = \"dbbca\", s3 = \"aadbbcbcac\"");
        try {
            String s1 = "aabcc";
            String s2 = "dbbca";
            String s3 = "aadbbcbcac";
            System.out.println("  Output  : " + _tcShow(_tcSol.isInterleave(s1, s2, s3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"aabcc\", s2 = \"dbbca\", s3 = \"aadbbbaccc\"");
        try {
            String s1 = "aabcc";
            String s2 = "dbbca";
            String s3 = "aadbbbaccc";
            System.out.println("  Output  : " + _tcShow(_tcSol.isInterleave(s1, s2, s3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s1 = \"\", s2 = \"\", s3 = \"\"");
        try {
            String s1 = "";
            String s2 = "";
            String s3 = "";
            System.out.println("  Output  : " + _tcShow(_tcSol.isInterleave(s1, s2, s3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}