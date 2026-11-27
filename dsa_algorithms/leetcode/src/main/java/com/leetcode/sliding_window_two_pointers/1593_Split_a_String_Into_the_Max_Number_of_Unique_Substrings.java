package com.leetcode.sliding_window_two_pointers;

class Solution1593 {
    private Set<String> st = new HashSet<>();
    private int ans;
    private String s;

    public int maxUniqueSplit(String s) {
        this.s = s;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (st.size() + s.length() - i <= ans) {
            return;
        }
        if (i >= s.length()) {
            ans = Math.max(ans, st.size());
            return;
        }
        for (int j = i + 1; j <= s.length(); ++j) {
            String t = s.substring(i, j);
            if (st.add(t)) {
                dfs(j);
                st.remove(t);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1593 _tcSol = new Solution1593();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"ababccc\"");
        try {
            String s = "ababccc";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxUniqueSplit(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aba\"");
        try {
            String s = "aba";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxUniqueSplit(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"aa\"");
        try {
            String s = "aa";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxUniqueSplit(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
