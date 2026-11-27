package com.leetcode.arrays_hashing_greedy;

class Solution0163 {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        if (n == 0) {
            return List.of(List.of(lower, upper));
        }
        List<List<Integer>> ans = new ArrayList<>();
        if (nums[0] > lower) {
            ans.add(List.of(lower, nums[0] - 1));
        }
        for (int i = 1; i < n; ++i) {
            if (nums[i] - nums[i - 1] > 1) {
                ans.add(List.of(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (nums[n - 1] < upper) {
            ans.add(List.of(nums[n - 1] + 1, upper));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0163 _tcSol = new Solution0163();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,3,50,75], lower = 0, upper = 99");
        try {
            int[] nums = new int[]{0, 1, 3, 50, 75};
            int lower = 0;
            int upper = 99;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMissingRanges(nums, lower, upper)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,2],[4,49],[51,74],[76,99]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1], lower = -1, upper = -1");
        try {
            int[] nums = new int[]{-1};
            int lower = -1;
            int upper = -1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMissingRanges(nums, lower, upper)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}