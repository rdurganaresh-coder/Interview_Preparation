package com.leetcode.backtracking;

class Solution0040 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        dfs(0, target);
        return ans;
    }

    private void dfs(int i, int s) {
        if (s == 0) {
            ans.add(new ArrayList<>(t));
            return;
        }
        if (i >= candidates.length || s < candidates[i]) {
            return;
        }
        for (int j = i; j < candidates.length; ++j) {
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            t.add(candidates[j]);
            dfs(j + 1, s - candidates[j]);
            t.remove(t.size() - 1);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0040 _tcSol = new Solution0040();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "candidates = [10,1,2,7,6,1,5], target = 8");
        try {
            int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
            int target = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.combinationSum2(candidates, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[ [1,1,6], [1,2,5], [1,7], [2,6] ]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "candidates = [2,5,2,1,2], target = 5");
        try {
            int[] candidates = new int[]{2, 5, 2, 1, 2};
            int target = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.combinationSum2(candidates, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[ [1,2,2], [5] ]");
        System.out.println();
    }
}