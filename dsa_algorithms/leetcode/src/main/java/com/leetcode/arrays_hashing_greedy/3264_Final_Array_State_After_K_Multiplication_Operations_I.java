package com.leetcode.arrays_hashing_greedy;

class Solution3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq
            = new PriorityQueue<>((i, j) -> nums[i] - nums[j] == 0 ? i - j : nums[i] - nums[j]);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(i);
        }
        while (k-- > 0) {
            int i = pq.poll();
            nums[i] *= multiplier;
            pq.offer(i);
        }
        return nums;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3264 _tcSol = new Solution3264();
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
        System.out.println("  Input   : " + "nums = [1,2], k = 3, multiplier = 4");
        try {
            int[] nums = new int[]{1, 2};
            int k = 3;
            int multiplier = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.getFinalState(nums, k, multiplier)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[16,8]");
        System.out.println();
    }
}
