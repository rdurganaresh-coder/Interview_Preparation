package com.leetcode.dynamic_programming;

class Solution3574 {
    public long maxGCDScore(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int x = nums[i]; x % 2 == 0; x /= 2) {
                ++cnt[i];
            }
        }
        long ans = 0;
        for (int l = 0; l < n; ++l) {
            int g = 0;
            int mi = 1 << 30;
            int t = 0;
            for (int r = l; r < n; ++r) {
                g = gcd(g, nums[r]);
                if (cnt[r] < mi) {
                    mi = cnt[r];
                    t = 1;
                } else if (cnt[r] == mi) {
                    ++t;
                }
                ans = Math.max(ans, (r - l + 1L) * (t > k ? g : g * 2));
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3574 _tcSol = new Solution3574();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,4], k = 1");
        try {
            int[] nums = new int[]{2, 4};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxGCDScore(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,5,7], k = 2");
        try {
            int[] nums = new int[]{3, 5, 7};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxGCDScore(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [5,5,5], k = 1");
        try {
            int[] nums = new int[]{5, 5, 5};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxGCDScore(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}