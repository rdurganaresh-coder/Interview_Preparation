package com.leetcode.arrays_hashing_greedy;

class Solution0228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0, j, n = nums.length; i < n; i = j + 1) {
            j = i;
            while (j + 1 < n && nums[j + 1] == nums[j] + 1) {
                ++j;
            }
            ans.add(f(nums, i, j));
        }
        return ans;
    }

    private String f(int[] nums, int i, int j) {
        return i == j ? nums[i] + "" : String.format("%d->%d", nums[i], nums[j]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0228 _tcSol = new Solution0228();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,2,4,5,7]");
        try {
            int[] nums = new int[]{0, 1, 2, 4, 5, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.summaryRanges(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"0->2\",\"4->5\",\"7\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,2,3,4,6,8,9]");
        try {
            int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.summaryRanges(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"0\",\"2->4\",\"6\",\"8->9\"]");
        System.out.println();
    }
}