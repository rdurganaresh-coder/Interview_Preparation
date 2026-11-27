package com.leetcode.backtracking;

class Solution0022 {
    private List<String> ans = new ArrayList<>();
    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0, "");
        return ans;
    }

    private void dfs(int l, int r, String t) {
        if (l > n || r > n || l < r) {
            return;
        }
        if (l == n && r == n) {
            ans.add(t);
            return;
        }
        dfs(l + 1, r, t + "(");
        dfs(l, r + 1, t + ")");
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0022 _tcSol = new Solution0022();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3");
        try {
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.generateParenthesis(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"((()))\",\"(()())\",\"(())()\",\"()(())\",\"()()()\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.generateParenthesis(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"()\"]");
        System.out.println();
    }
}