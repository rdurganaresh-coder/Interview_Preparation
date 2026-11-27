package com.leetcode.backtracking;

class Solution0093 {
    private int n;
    private String s;
    private List<String> ans = new ArrayList<>();
    private List<String> t = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i >= n && t.size() == 4) {
            ans.add(String.join(".", t));
            return;
        }
        if (i >= n || t.size() >= 4) {
            return;
        }
        int x = 0;
        for (int j = i; j < Math.min(i + 3, n); ++j) {
            x = x * 10 + s.charAt(j) - '0';
            if (x > 255 || (s.charAt(i) == '0' && i != j)) {
                break;
            }
            t.add(s.substring(i, j + 1));
            dfs(j + 1);
            t.remove(t.size() - 1);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0093 _tcSol = new Solution0093();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"25525511135\"");
        try {
            String s = "25525511135";
            System.out.println("  Output  : " + _tcShow(_tcSol.restoreIpAddresses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"255.255.11.135\",\"255.255.111.35\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"0000\"");
        try {
            String s = "0000";
            System.out.println("  Output  : " + _tcShow(_tcSol.restoreIpAddresses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"0.0.0.0\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"101023\"");
        try {
            String s = "101023";
            System.out.println("  Output  : " + _tcShow(_tcSol.restoreIpAddresses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"1.0.10.23\",\"1.0.102.3\",\"10.1.0.23\",\"10.10.2.3\",\"101.0.2.3\"]");
        System.out.println();
    }
}