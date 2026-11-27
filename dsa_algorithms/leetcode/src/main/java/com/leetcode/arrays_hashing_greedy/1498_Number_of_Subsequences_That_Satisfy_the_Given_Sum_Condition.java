package com.leetcode.arrays_hashing_greedy;

class Solution1498 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        final int mod = (int) 1e9 + 7;
        int n = nums.length;
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            f[i] = (f[i - 1] * 2) % mod;
        }
        int ans = 0;
        for (int i = 0; i < n && nums[i] * 2 <= target; ++i) {
            int j = search(nums, target - nums[i], i + 1) - 1;
            ans = (ans + f[j - i]) % mod;
        }
        return ans;
    }

    private int search(int[] nums, int x, int left) {
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1498 _tcSol = new Solution1498();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,5,6,7], target = 9");
        try {
            int[] nums = new int[]{3, 5, 6, 7};
            int target = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubseq(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,3,6,8], target = 10");
        try {
            int[] nums = new int[]{3, 3, 6, 8};
            int target = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubseq(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,3,3,4,6,7], target = 12");
        try {
            int[] nums = new int[]{2, 3, 3, 4, 6, 7};
            int target = 12;
            System.out.println("  Output  : " + _tcShow(_tcSol.numSubseq(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "61");
        System.out.println();
    }
}