package com.leetcode.sql_database;

class Solution2233 {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : nums) {
            pq.offer(x);
        }
        while (k-- > 0) {
            pq.offer(pq.poll() + 1);
        }
        final int mod = (int) 1e9 + 7;
        long ans = 1;
        for (int x : pq) {
            ans = (ans * x) % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2233 _tcSol = new Solution2233();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,4], k = 5");
        try {
            int[] nums = new int[]{0, 4};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProduct(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [6,3,3,2], k = 2");
        try {
            int[] nums = new int[]{6, 3, 3, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumProduct(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "216");
        System.out.println();
    }
}
