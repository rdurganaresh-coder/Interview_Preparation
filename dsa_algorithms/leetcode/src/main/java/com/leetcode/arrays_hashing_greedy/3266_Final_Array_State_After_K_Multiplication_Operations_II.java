package com.leetcode.arrays_hashing_greedy;

class Solution3266 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) {
            return nums;
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        int n = nums.length;
        int m = Arrays.stream(nums).max().getAsInt();
        for (int i = 0; i < n; ++i) {
            pq.offer(new long[] {nums[i], i});
        }
        for (; k > 0 && pq.peek()[0] < m; --k) {
            long[] p = pq.poll();
            p[0] *= multiplier;
            pq.offer(p);
        }
        final int mod = (int) 1e9 + 7;
        for (int i = 0; i < n; ++i) {
            long[] p = pq.poll();
            long x = p[0];
            int j = (int) p[1];
            nums[j] = (int) ((x % mod) * qpow(multiplier, k / n + (i < k % n ? 1 : 0), mod) % mod);
        }
        return nums;
    }

    private int qpow(long a, long n, long mod) {
        long ans = 1 % mod;
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
        Solution3266 _tcSol = new Solution3266();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,3,5,6], k = 5, multiplier = 2");
        try {
            int[] nums = new int[]{2, 1, 3, 5, 6};
            int k = 5;
            int multiplier = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getFinalState(nums, k, multiplier)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[8,4,6,5,6]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [100000,2000], k = 2, multiplier = 1000000");
        try {
            int[] nums = new int[]{100000, 2000};
            int k = 2;
            int multiplier = 1000000;
            System.out.println("  Output  : " + _tcShow(_tcSol.getFinalState(nums, k, multiplier)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[999999307,999999993]");
        System.out.println();
    }
}
