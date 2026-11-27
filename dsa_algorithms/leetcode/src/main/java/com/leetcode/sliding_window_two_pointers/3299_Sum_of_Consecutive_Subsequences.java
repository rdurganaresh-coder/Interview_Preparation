package com.leetcode.sliding_window_two_pointers;

class Solution3299 {
    private final int mod = (int) 1e9 + 7;

    public int getSum(int[] nums) {
        long x = calc(nums);
        for (int i = 0, j = nums.length - 1; i < j; ++i, --j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        long y = calc(nums);
        long s = Arrays.stream(nums).asLongStream().sum();
        return (int) ((x + y + s) % mod);
    }

    private long calc(int[] nums) {
        int n = nums.length;
        long[] left = new long[n];
        long[] right = new long[n];
        Map<Integer, Long> cnt = new HashMap<>();
        for (int i = 1; i < n; ++i) {
            cnt.merge(nums[i - 1], (1 + cnt.getOrDefault(nums[i - 1] - 1, 0L)) % mod,
                (a, b) -> (a + b) % mod);
            left[i] = cnt.getOrDefault(nums[i] - 1, 0L);
        }
        cnt.clear();
        for (int i = n - 2; i >= 0; --i) {
            cnt.merge(nums[i + 1], (1 + cnt.getOrDefault(nums[i + 1] + 1, 0L)) % mod,
                (a, b) -> (a + b) % mod);
            right[i] = cnt.getOrDefault(nums[i] + 1, 0L);
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = (ans + (left[i] + right[i] + left[i] * right[i] % mod) * nums[i] % mod) % mod;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3299 _tcSol = new Solution3299();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2]");
        try {
            int[] nums = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.getSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,4,2,3]");
        try {
            int[] nums = new int[]{1, 4, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.getSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "31");
        System.out.println();
    }
}
