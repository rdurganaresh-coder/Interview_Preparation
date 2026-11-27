package com.leetcode.strings;

class Solution1415 {
    private List<String> ans = new ArrayList<>();
    private StringBuilder s = new StringBuilder();
    private int n, k;

    public String getHappyString(int n, int k) {
        this.n = n;
        this.k = k;
        dfs();
        return ans.size() < k ? "" : ans.get(k - 1);
    }

    private void dfs() {
        if (s.length() == n) {
            ans.add(s.toString());
            return;
        }
        if (ans.size() >= k) {
            return;
        }
        for (char c : "abc".toCharArray()) {
            if (s.isEmpty() || s.charAt(s.length() - 1) != c) {
                s.append(c);
                dfs();
                s.deleteCharAt(s.length() - 1);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1415 _tcSol = new Solution1415();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1, k = 3");
        try {
            int n = 1;
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.getHappyString(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"c\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1, k = 4");
        try {
            int n = 1;
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.getHappyString(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, k = 9");
        try {
            int n = 3;
            int k = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.getHappyString(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"cab\"");
        System.out.println();
    }
}
