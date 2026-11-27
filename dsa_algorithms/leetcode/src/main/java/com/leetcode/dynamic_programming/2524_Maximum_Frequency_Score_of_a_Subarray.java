package com.leetcode.dynamic_programming;

class Solution2524 {
    private final int mod = (int) 1e9 + 7;

    public int maxFrequencyScore(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < k; ++i) {
            cnt.merge(nums[i], 1, Integer::sum);
        }
        long cur = 0;
        for (var e : cnt.entrySet()) {
            cur = (cur + qpow(e.getKey(), e.getValue())) % mod;
        }
        long ans = cur;
        for (int i = k; i < nums.length; ++i) {
            int a = nums[i - k];
            int b = nums[i];
            if (a != b) {
                if (cnt.getOrDefault(b, 0) > 0) {
                    cur += (b - 1) * qpow(b, cnt.get(b)) % mod;
                } else {
                    cur += b;
                }
                if (cnt.getOrDefault(a, 0) > 1) {
                    cur -= (a - 1) * qpow(a, cnt.get(a) - 1) % mod;
                } else {
                    cur -= a;
                }
                cur = (cur + mod) % mod;
                cnt.put(b, cnt.getOrDefault(b, 0) + 1);
                cnt.put(a, cnt.getOrDefault(a, 0) - 1);
                ans = Math.max(ans, cur);
            }
        }
        return (int) ans;
    }

    private long qpow(long a, long n) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2524 _tcSol = new Solution2524();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,1,2,1,2], k = 3");
        try {
            int[] nums = new int[]{1, 1, 1, 2, 1, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFrequencyScore(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1,1,1,1], k = 4");
        try {
            int[] nums = new int[]{1, 1, 1, 1, 1, 1};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFrequencyScore(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}