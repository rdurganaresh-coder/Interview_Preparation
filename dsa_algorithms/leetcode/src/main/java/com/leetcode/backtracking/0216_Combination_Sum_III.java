package com.leetcode.backtracking;

class Solution0216 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        dfs(1, n);
        return ans;
    }

    private void dfs(int i, int s) {
        if (s == 0) {
            if (t.size() == k) {
                ans.add(new ArrayList<>(t));
            }
            return;
        }
        if (i > 9 || i > s || t.size() >= k) {
            return;
        }
        t.add(i);
        dfs(i + 1, s - i);
        t.remove(t.size() - 1);
        dfs(i + 1, s);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0216 _tcSol = new Solution0216();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 3, n = 7");
        try {
            int k = 3;
            int n = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.combinationSum3(k, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2,4]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 3, n = 9");
        try {
            int k = 3;
            int n = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.combinationSum3(k, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2,6],[1,3,5],[2,3,4]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "k = 4, n = 1");
        try {
            int k = 4;
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.combinationSum3(k, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}