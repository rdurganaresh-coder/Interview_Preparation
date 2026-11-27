package com.leetcode.arrays_hashing_greedy;

class Solution2208 {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double s = 0;
        for (int x : nums) {
            s += x;
            pq.offer((double) x);
        }
        s /= 2.0;
        int ans = 0;
        while (s > 0) {
            double t = pq.poll() / 2.0;
            s -= t;
            pq.offer(t);
            ++ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2208 _tcSol = new Solution2208();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,19,8,1]");
        try {
            int[] nums = new int[]{5, 19, 8, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.halveArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,8,20]");
        try {
            int[] nums = new int[]{3, 8, 20};
            System.out.println("  Output  : " + _tcShow(_tcSol.halveArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
