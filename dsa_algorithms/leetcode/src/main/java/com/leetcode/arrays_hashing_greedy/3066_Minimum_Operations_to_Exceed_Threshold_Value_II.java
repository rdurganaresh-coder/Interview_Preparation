package com.leetcode.arrays_hashing_greedy;

class Solution3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int x : nums) {
            pq.offer((long) x);
        }
        int ans = 0;
        for (; pq.size() > 1 && pq.peek() < k; ++ans) {
            long x = pq.poll(), y = pq.poll();
            pq.offer(x * 2 + y);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3066 _tcSol = new Solution3066();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,11,10,1,3], k = 10");
        try {
            int[] nums = new int[]{2, 11, 10, 1, 3};
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,2,4,9], k = 20");
        try {
            int[] nums = new int[]{1, 1, 2, 4, 9};
            int k = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
