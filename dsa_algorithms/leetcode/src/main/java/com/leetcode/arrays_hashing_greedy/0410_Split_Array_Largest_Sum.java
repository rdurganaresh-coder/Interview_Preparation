package com.leetcode.arrays_hashing_greedy;

class Solution0410 {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int x : nums) {
            left = Math.max(left, x);
            right += x;
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int mx, int k) {
        int s = 1 << 30, cnt = 0;
        for (int x : nums) {
            s += x;
            if (s > mx) {
                ++cnt;
                s = x;
            }
        }
        return cnt <= k;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0410 _tcSol = new Solution0410();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [7,2,5,10,8], k = 2");
        try {
            int[] nums = new int[]{7, 2, 5, 10, 8};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.splitArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5], k = 2");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.splitArray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}