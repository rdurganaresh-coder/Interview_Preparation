package com.leetcode.backtracking;

class Solution0784 {
    private List<String> ans = new ArrayList<>();
    private char[] t;

    public List<String> letterCasePermutation(String s) {
        t = s.toCharArray();
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i >= t.length) {
            ans.add(new String(t));
            return;
        }
        dfs(i + 1);
        if (Character.isLetter(t[i])) {
            t[i] ^= 32;
            dfs(i + 1);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0784 _tcSol = new Solution0784();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"a1b2\"");
        try {
            String s = "a1b2";
            System.out.println("  Output  : " + _tcShow(_tcSol.letterCasePermutation(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a1b2\",\"a1B2\",\"A1b2\",\"A1B2\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"3z4\"");
        try {
            String s = "3z4";
            System.out.println("  Output  : " + _tcShow(_tcSol.letterCasePermutation(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"3z4\",\"3Z4\"]");
        System.out.println();
    }
}
