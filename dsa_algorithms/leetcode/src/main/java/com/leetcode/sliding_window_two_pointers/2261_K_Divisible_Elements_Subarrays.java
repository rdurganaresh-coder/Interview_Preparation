package com.leetcode.sliding_window_two_pointers;

class Solution2261 {
    public int countDistinct(int[] nums, int k, int p) {
        Set<Long> s = new HashSet<>();
        int n = nums.length;
        int base1 = 131, base2 = 13331;
        int mod1 = (int) 1e9 + 7, mod2 = (int) 1e9 + 9;
        for (int i = 0; i < n; ++i) {
            long h1 = 0, h2 = 0;
            int cnt = 0;
            for (int j = i; j < n; ++j) {
                cnt += nums[j] % p == 0 ? 1 : 0;
                if (cnt > k) {
                    break;
                }
                h1 = (h1 * base1 + nums[j]) % mod1;
                h2 = (h2 * base2 + nums[j]) % mod2;
                s.add(h1 << 32 | h2);
            }
        }
        return s.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2261 _tcSol = new Solution2261();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,3,2,2], k = 2, p = 2");
        try {
            int[] nums = new int[]{2, 3, 3, 2, 2};
            int k = 2;
            int p = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countDistinct(nums, k, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4], k = 4, p = 1");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            int k = 4;
            int p = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countDistinct(nums, k, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}
