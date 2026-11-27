package com.leetcode.arrays_hashing_greedy;

class Solution2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2089 _tcSol = new Solution2089();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,5,2,3], target = 2");
        try {
            int[] nums = new int[]{1, 2, 5, 2, 3};
            int target = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.targetIndices(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,5,2,3], target = 3");
        try {
            int[] nums = new int[]{1, 2, 5, 2, 3};
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.targetIndices(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,5,2,3], target = 5");
        try {
            int[] nums = new int[]{1, 2, 5, 2, 3};
            int target = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.targetIndices(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4]");
        System.out.println();
    }
}