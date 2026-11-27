package com.leetcode.sliding_window_two_pointers;

class Solution0442 {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0442 _tcSol = new Solution0442();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,3,2,7,8,2,3,1]");
        try {
            int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDuplicates(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,2]");
        try {
            int[] nums = new int[]{1, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDuplicates(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1]");
        try {
            int[] nums = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDuplicates(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}