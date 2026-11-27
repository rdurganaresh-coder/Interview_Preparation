package com.leetcode.arrays_hashing_greedy;

class Solution2897 {
    public int maxSum(List<Integer> nums, int k) {
        final int mod = (int) 1e9 + 7;
        int[] cnt = new int[31];
        for (int x : nums) {
            for (int i = 0; i < 31; ++i) {
                if ((x >> i & 1) == 1) {
                    ++cnt[i];
                }
            }
        }
        long ans = 0;
        while (k-- > 0) {
            int x = 0;
            for (int i = 0; i < 31; ++i) {
                if (cnt[i] > 0) {
                    x |= 1 << i;
                    --cnt[i];
                }
            }
            ans = (ans + 1L * x * x) % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution2897 _tcSol = new Solution2897();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,6,5,8], k = 2");
        try {
            List<Integer> nums = _tcL(2, 6, 5, 8);
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "261");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,5,4,7], k = 3");
        try {
            List<Integer> nums = _tcL(4, 5, 4, 7);
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "90");
        System.out.println();
    }
}