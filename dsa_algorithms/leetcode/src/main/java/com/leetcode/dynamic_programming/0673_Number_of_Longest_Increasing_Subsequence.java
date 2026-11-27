package com.leetcode.dynamic_programming;

class Solution0673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] cnt = new int[n];
        int mx = 0, ans = 0;
        for (int i = 0; i < n; ++i) {
            f[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (f[i] == f[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (mx < f[i]) {
                mx = f[i];
                ans = cnt[i];
            } else if (mx == f[i]) {
                ans += cnt[i];
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0673 _tcSol = new Solution0673();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,5,4,7]");
        try {
            int[] nums = new int[]{1, 3, 5, 4, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.findNumberOfLIS(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,2,2,2]");
        try {
            int[] nums = new int[]{2, 2, 2, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findNumberOfLIS(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}