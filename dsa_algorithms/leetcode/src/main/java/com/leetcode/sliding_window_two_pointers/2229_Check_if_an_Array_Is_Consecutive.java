package com.leetcode.sliding_window_two_pointers;

class Solution2229 {
    public boolean isConsecutive(int[] nums) {
        int mi = nums[0], mx = 0;
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            if (!s.add(x)) {
                return false;
            }
            mi = Math.min(mi, x);
            mx = Math.max(mx, x);
        }
        return mx - mi + 1 == nums.length;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2229 _tcSol = new Solution2229();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,4,2]");
        try {
            int[] nums = new int[]{1, 3, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.isConsecutive(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3]");
        try {
            int[] nums = new int[]{1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.isConsecutive(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,5,4]");
        try {
            int[] nums = new int[]{3, 5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.isConsecutive(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
