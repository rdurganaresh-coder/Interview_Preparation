package com.leetcode.binary_search;

class Solution1918 {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int l = 1 << 30, r = 0;
        for (int x : nums) {
            l = Math.min(l, x);
            r += x;
        }
        while (l < r) {
            int mid = (l + r) >> 1;
            if (f(nums, mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int f(int[] nums, int s) {
        int t = 0, j = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            t += nums[i];
            while (t > s) {
                t -= nums[j++];
            }
            cnt += i - j + 1;
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1918 _tcSol = new Solution1918();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,3], k = 4");
        try {
            int[] nums = new int[]{2, 1, 3};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallestSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,3,5,5], k = 7");
        try {
            int[] nums = new int[]{3, 3, 5, 5};
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallestSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}