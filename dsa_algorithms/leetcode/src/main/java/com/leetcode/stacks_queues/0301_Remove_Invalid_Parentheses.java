package com.leetcode.stacks_queues;

class Solution0301 {
    private String s;
    private int n;
    private Set<String> ans = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        this.n = s.length();
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++l;
            } else if (c == ')') {
                if (l > 0) {
                    --l;
                } else {
                    ++r;
                }
            }
        }
        dfs(0, l, r, 0, 0, "");
        return new ArrayList<>(ans);
    }

    private void dfs(int i, int l, int r, int lcnt, int rcnt, String t) {
        if (i == n) {
            if (l == 0 && r == 0) {
                ans.add(t);
            }
            return;
        }
        if (n - i < l + r || lcnt < rcnt) {
            return;
        }
        char c = s.charAt(i);
        if (c == '(' && l > 0) {
            dfs(i + 1, l - 1, r, lcnt, rcnt, t);
        }
        if (c == ')' && r > 0) {
            dfs(i + 1, l, r - 1, lcnt, rcnt, t);
        }
        int x = c == '(' ? 1 : 0;
        int y = c == ')' ? 1 : 0;
        dfs(i + 1, l, r, lcnt + x, rcnt + y, t + c);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0301 _tcSol = new Solution0301();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"()())()\"");
        try {
            String s = "()())()";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeInvalidParentheses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"(())()\",\"()()()\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"(a)())()\"");
        try {
            String s = "(a)())()";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeInvalidParentheses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"(a())()\",\"(a)()()\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \")(\"");
        try {
            String s = ")(";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeInvalidParentheses(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"\"]");
        System.out.println();
    }
}