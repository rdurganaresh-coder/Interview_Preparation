package com.leetcode.dynamic_programming;

class Solution2530 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int v : nums) {
            pq.offer(v);
        }
        long ans = 0;
        while (k-- > 0) {
            int v = pq.poll();
            ans += v;
            pq.offer((v + 2) / 3);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2530 _tcSol = new Solution2530();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [10,10,10,10,10], k = 5");
        try {
            int[] nums = new int[]{10, 10, 10, 10, 10};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxKelements(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "50");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,10,3,3,3], k = 3");
        try {
            int[] nums = new int[]{1, 10, 3, 3, 3};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxKelements(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();
    }
}