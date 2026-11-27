package com.leetcode.arrays_hashing_greedy;

class Solution2439 {
    private int[] nums;

    public int minimizeArrayValue(int[] nums) {
        this.nums = nums;
        int left = 0, right = max(nums);
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int mx) {
        long d = 0;
        for (int i = nums.length - 1; i > 0; --i) {
            d = Math.max(0, d + nums[i] - mx);
        }
        return nums[0] + d <= mx;
    }

    private int max(int[] nums) {
        int v = nums[0];
        for (int x : nums) {
            v = Math.max(v, x);
        }
        return v;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2439 _tcSol = new Solution2439();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,7,1,6]");
        try {
            int[] nums = new int[]{3, 7, 1, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeArrayValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,1]");
        try {
            int[] nums = new int[]{10, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeArrayValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}