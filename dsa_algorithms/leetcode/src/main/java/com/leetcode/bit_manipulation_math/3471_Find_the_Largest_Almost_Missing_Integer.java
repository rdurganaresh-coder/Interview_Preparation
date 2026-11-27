package com.leetcode.bit_manipulation_math;

class Solution3471 {
    private int[] nums;

    public int largestInteger(int[] nums, int k) {
        this.nums = nums;
        if (k == 1) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int x : nums) {
                cnt.merge(x, 1, Integer::sum);
            }
            int ans = -1;
            for (var e : cnt.entrySet()) {
                if (e.getValue() == 1) {
                    ans = Math.max(ans, e.getKey());
                }
            }
            return ans;
        }
        if (k == nums.length) {
            return Arrays.stream(nums).max().getAsInt();
        }
        return Math.max(f(0), f(nums.length - 1));
    }

    private int f(int k) {
        for (int i = 0; i < nums.length; ++i) {
            if (i != k && nums[i] == nums[k]) {
                return -1;
            }
        }
        return nums[k];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3471 _tcSol = new Solution3471();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,9,2,1,7], k = 3");
        try {
            int[] nums = new int[]{3, 9, 2, 1, 7};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestInteger(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,9,7,2,1,7], k = 4");
        try {
            int[] nums = new int[]{3, 9, 7, 2, 1, 7};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestInteger(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [0,0], k = 1");
        try {
            int[] nums = new int[]{0, 0};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestInteger(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
