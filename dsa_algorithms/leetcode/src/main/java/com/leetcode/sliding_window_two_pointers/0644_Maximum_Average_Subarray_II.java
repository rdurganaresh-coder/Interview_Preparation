package com.leetcode.sliding_window_two_pointers;

class Solution0644 {
    public double findMaxAverage(int[] nums, int k) {
        double eps = 1e-5;
        double l = 1e10, r = -1e10;
        for (int x : nums) {
            l = Math.min(l, x);
            r = Math.max(r, x);
        }
        while (r - l >= eps) {
            double mid = (l + r) / 2;
            if (check(nums, k, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int k, double v) {
        double s = 0;
        for (int i = 0; i < k; ++i) {
            s += nums[i] - v;
        }
        if (s >= 0) {
            return true;
        }
        double t = 0;
        double mi = 0;
        for (int i = k; i < nums.length; ++i) {
            s += nums[i] - v;
            t += nums[i - k] - v;
            mi = Math.min(mi, t);
            if (s >= mi) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0644 _tcSol = new Solution0644();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,12,-5,-6,50,3], k = 4");
        try {
            int[] nums = new int[]{1, 12, -5, -6, 50, 3};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxAverage(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12.75000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5], k = 1");
        try {
            int[] nums = new int[]{5};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxAverage(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5.00000");
        System.out.println();
    }
}