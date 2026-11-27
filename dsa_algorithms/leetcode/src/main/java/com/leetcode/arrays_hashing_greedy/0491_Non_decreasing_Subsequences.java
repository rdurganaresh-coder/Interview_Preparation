package com.leetcode.arrays_hashing_greedy;

class Solution0491 {
    private int[] nums;
    private List<List<Integer>> ans;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        ans = new ArrayList<>();
        dfs(0, -1000, new ArrayList<>());
        return ans;
    }

    private void dfs(int u, int last, List<Integer> t) {
        if (u == nums.length) {
            if (t.size() > 1) {
                ans.add(new ArrayList<>(t));
            }
            return;
        }
        if (nums[u] >= last) {
            t.add(nums[u]);
            dfs(u + 1, nums[u], t);
            t.remove(t.size() - 1);
        }
        if (nums[u] != last) {
            dfs(u + 1, last, t);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0491 _tcSol = new Solution0491();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,6,7,7]");
        try {
            int[] nums = new int[]{4, 6, 7, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.findSubsequences(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,4,3,2,1]");
        try {
            int[] nums = new int[]{4, 4, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findSubsequences(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[4,4]]");
        System.out.println();
    }
}