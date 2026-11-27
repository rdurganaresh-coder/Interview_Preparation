package com.leetcode.arrays_hashing_greedy;

class Solution2902 {
    static final int MOD = 1_000_000_007;
    public int countSubMultisets(List<Integer> nums, int l, int r) {
        Map<Integer, Integer> count = new HashMap<>();
        int total = 0;
        for (int num : nums) {
            total += num;
            if (num <= r) {
                count.merge(num, 1, Integer::sum);
            }
        }
        if (total < l) {
            return 0;
        }
        r = Math.min(r, total);
        int[] dp = new int[r + 1];
        dp[0] = count.getOrDefault(0, 0) + 1;
        count.remove(Integer.valueOf(0));
        int sum = 0;
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            int num = e.getKey();
            int c = e.getValue();
            sum = Math.min(sum + c * num, r);
            // prefix part
            // dp[i] = dp[i] + dp[i - num] + ... + dp[i - c*num] + dp[i-(c+1)*num] + ... + dp[i %
            // num]
            for (int i = num; i <= sum; i++) {
                dp[i] = (dp[i] + dp[i - num]) % MOD;
            }
            int temp = (c + 1) * num;
            // correction part
            // subtract dp[i - (freq + 1) * num] to the end part.
            // leves dp[i] = dp[i] + dp[i-num] +...+ dp[i - c*num];
            for (int i = sum; i >= temp; i--) {
                dp[i] = (dp[i] - dp[i - temp] + MOD) % MOD;
            }
        }
        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans += dp[i];
            ans %= MOD;
        }
        return ans;
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
        Solution2902 _tcSol = new Solution2902();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2,3], l = 6, r = 6");
        try {
            List<Integer> nums = _tcL(1, 2, 2, 3);
            int l = 6;
            int r = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubMultisets(nums, l, r)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,1,4,2,7], l = 1, r = 5");
        try {
            List<Integer> nums = _tcL(2, 1, 4, 2, 7);
            int l = 1;
            int r = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubMultisets(nums, l, r)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,1,3,5,2], l = 3, r = 5");
        try {
            List<Integer> nums = _tcL(1, 2, 1, 3, 5, 2);
            int l = 3;
            int r = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubMultisets(nums, l, r)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}