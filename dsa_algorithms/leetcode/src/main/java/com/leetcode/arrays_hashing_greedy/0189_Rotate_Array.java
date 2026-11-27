package com.leetcode.arrays_hashing_greedy;

class Solution0189 {
    private int[] nums;

    public void rotate(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        k %= n;
        reverse(0, n - 1);
        reverse(0, k - 1);
        reverse(k, n - 1);
    }

    private void reverse(int i, int j) {
        for (; i < j; ++i, --j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0189 _tcSol = new Solution0189();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5,6,7], k = 3");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
            int k = 3;
            _tcSol.rotate(nums, k);
            System.out.println("  Output  : " + _tcShow(nums));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,6,7,1,2,3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,-100,3,99], k = 2");
        try {
            int[] nums = new int[]{-1, -100, 3, 99};
            int k = 2;
            _tcSol.rotate(nums, k);
            System.out.println("  Output  : " + _tcShow(nums));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,99,-1,-100]");
        System.out.println();
    }
}