package com.leetcode.backtracking;

class Solution0039 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        dfs(0, target);
        return ans;
    }

    private void dfs(int i, int s) {
        if (s == 0) {
            ans.add(new ArrayList(t));
            return;
        }
        if (s < candidates[i]) {
            return;
        }
        for (int j = i; j < candidates.length; ++j) {
            t.add(candidates[j]);
            dfs(j, s - candidates[j]);
            t.remove(t.size() - 1);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0039 _tcSol = new Solution0039();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "candidates = [2,3,6,7], target = 7");
        try {
            int[] candidates = new int[]{2, 3, 6, 7};
            int target = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.combinationSum(candidates, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,2,3],[7]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "candidates = [2,3,5], target = 8");
        try {
            int[] candidates = new int[]{2, 3, 5};
            int target = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.combinationSum(candidates, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,2,2,2],[2,3,3],[3,5]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "candidates = [2], target = 1");
        try {
            int[] candidates = new int[]{2};
            int target = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.combinationSum(candidates, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}