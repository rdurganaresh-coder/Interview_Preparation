package com.leetcode.sliding_window_two_pointers;

class Solution2941 {
    public long maxGcdSum(int[] nums, int k) {
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        List<int[]> f = new ArrayList<>();
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            List<int[]> g = new ArrayList<>();
            for (var e : f) {
                int j = e[0], x = e[1];
                int y = gcd(x, nums[i]);
                if (g.isEmpty() || g.get(g.size() - 1)[1] != y) {
                    g.add(new int[] {j, y});
                }
            }
            f = g;
            f.add(new int[] {i, nums[i]});
            for (var e : f) {
                int j = e[0], x = e[1];
                if (i - j + 1 >= k) {
                    ans = Math.max(ans, (s[i + 1] - s[j]) * x);
                }
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
        Solution2941 _tcSol = new Solution2941();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,4,4,4,2], k = 2");
        try {
            int[] nums = new int[]{2, 1, 4, 4, 4, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxGcdSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "48");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [7,3,9,4], k = 1");
        try {
            int[] nums = new int[]{7, 3, 9, 4};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxGcdSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "81");
        System.out.println();
    }
}