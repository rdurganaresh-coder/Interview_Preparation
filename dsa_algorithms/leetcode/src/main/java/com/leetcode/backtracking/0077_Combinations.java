package com.leetcode.backtracking;

class Solution0077 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private int n;
    private int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(1);
        return ans;
    }

    private void dfs(int i) {
        if (t.size() == k) {
            ans.add(new ArrayList<>(t));
            return;
        }
        if (i > n) {
            return;
        }
        t.add(i);
        dfs(i + 1);
        t.remove(t.size() - 1);
        dfs(i + 1);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0077 _tcSol = new Solution0077();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, k = 2");
        try {
            int n = 4;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.combine(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1, k = 1");
        try {
            int n = 1;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.combine(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1]]");
        System.out.println();
    }
}