package com.leetcode.backtracking;

class Solution0254 {
    private List<Integer> t = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> getFactors(int n) {
        dfs(n, 2);
        return ans;
    }

    private void dfs(int n, int i) {
        if (!t.isEmpty()) {
            List<Integer> cp = new ArrayList<>(t);
            cp.add(n);
            ans.add(cp);
        }
        for (int j = i; j <= n / j; ++j) {
            if (n % j == 0) {
                t.add(j);
                dfs(n / j, j);
                t.remove(t.size() - 1);
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0254 _tcSol = new Solution0254();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.getFactors(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 12");
        try {
            int n = 12;
            System.out.println("  Output  : " + _tcShow(_tcSol.getFactors(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,6],[3,4],[2,2,3]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 37");
        try {
            int n = 37;
            System.out.println("  Output  : " + _tcShow(_tcSol.getFactors(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}