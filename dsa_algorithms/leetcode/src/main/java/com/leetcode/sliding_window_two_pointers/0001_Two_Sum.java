package com.leetcode.sliding_window_two_pointers;

class Solution0001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0;; ++i) {
            int x = nums[i];
            int y = target - x;
            if (d.containsKey(y)) {
                return new int[] {d.get(y), i};
            }
            d.put(x, i);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0001 _tcSol = new Solution0001();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,7,11,15], target = 9");
        try {
            int[] nums = new int[]{2, 7, 11, 15};
            int target = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.twoSum(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,2,4], target = 6");
        try {
            int[] nums = new int[]{3, 2, 4};
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.twoSum(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,3], target = 6");
        try {
            int[] nums = new int[]{3, 3};
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.twoSum(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();
    }
}
