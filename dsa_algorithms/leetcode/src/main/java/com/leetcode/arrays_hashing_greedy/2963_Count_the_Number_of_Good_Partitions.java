package com.leetcode.arrays_hashing_greedy;

class Solution2963 {
    public int numberOfGoodPartitions(int[] nums) {
        Map<Integer, Integer> last = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            last.put(nums[i], i);
        }
        final int mod = (int) 1e9 + 7;
        int j = -1;
        int k = 0;
        for (int i = 0; i < n; ++i) {
            j = Math.max(j, last.get(nums[i]));
            k += i == j ? 1 : 0;
        }
        return qpow(2, k - 1, mod);
    }

    private int qpow(long a, int n, int mod) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2963 _tcSol = new Solution2963();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfGoodPartitions(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfGoodPartitions(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,1,3]");
        try {
            int[] nums = new int[]{1, 2, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfGoodPartitions(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}