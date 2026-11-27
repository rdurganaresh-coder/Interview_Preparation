package com.leetcode.sliding_window_two_pointers;

class Solution3411 {
    public int maxLength(int[] nums) {
        int mx = 0, ml = 1;
        for (int x : nums) {
            mx = Math.max(mx, x);
            ml = lcm(ml, x);
        }
        int maxP = ml * mx;
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int p = 1, g = 0, l = 1;
            for (int j = i; j < n; ++j) {
                p *= nums[j];
                g = gcd(g, nums[j]);
                l = lcm(l, nums[j]);
                if (p == g * l) {
                    ans = Math.max(ans, j - i + 1);
                }
                if (p > maxP) {
                    break;
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3411 _tcSol = new Solution3411();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1,2,1,1,1]");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,4,5,6]");
        try {
            int[] nums = new int[]{2, 3, 4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,1,4,5,1]");
        try {
            int[] nums = new int[]{1, 2, 3, 1, 4, 5, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
