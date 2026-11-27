package com.leetcode.arrays_hashing_greedy;

class Solution3404 {
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int r = 4; r < n - 2; ++r) {
            int c = nums[r];
            for (int s = r + 2; s < n; ++s) {
                int d = nums[s];
                int g = gcd(c, d);
                cnt.merge(((d / g) << 12) | (c / g), 1, Integer::sum);
            }
        }
        long ans = 0;
        for (int q = 2; q < n - 4; ++q) {
            int b = nums[q];
            for (int p = 0; p < q - 1; ++p) {
                int a = nums[p];
                int g = gcd(a, b);
                ans += cnt.getOrDefault(((a / g) << 12) | (b / g), 0);
            }
            int c = nums[q + 2];
            for (int s = q + 4; s < n; ++s) {
                int d = nums[s];
                int g = gcd(c, d);
                cnt.merge(((d / g) << 12) | (c / g), -1, Integer::sum);
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
        Solution3404 _tcSol = new Solution3404();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,3,6,1]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 3, 6, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubsequences(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,4,3,4,3,4,3,4]");
        try {
            int[] nums = new int[]{3, 4, 3, 4, 3, 4, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubsequences(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
