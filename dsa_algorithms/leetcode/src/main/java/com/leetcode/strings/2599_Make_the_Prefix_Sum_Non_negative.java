package com.leetcode.strings;

class Solution2599 {
    public int makePrefSumNonNegative(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        long s = 0;
        for (int x : nums) {
            s += x;
            if (x < 0) {
                pq.offer(x);
            }
            while (s < 0) {
                s -= pq.poll();
                ++ans;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2599 _tcSol = new Solution2599();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,-5,4]");
        try {
            int[] nums = new int[]{2, 3, -5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.makePrefSumNonNegative(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,-5,-2,6]");
        try {
            int[] nums = new int[]{3, -5, -2, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.makePrefSumNonNegative(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}