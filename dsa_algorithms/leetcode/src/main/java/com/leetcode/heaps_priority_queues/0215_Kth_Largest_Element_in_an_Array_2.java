package com.leetcode.heaps_priority_queues;

class Solution0215_2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        for (int x : nums) {
            minQ.offer(x);
            if (minQ.size() > k) {
                minQ.poll();
            }
        }
        return minQ.peek();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0215_2 _tcSol = new Solution0215_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,2,1,5,6,4], k = 2");
        try {
            int[] nums = new int[]{3, 2, 1, 5, 6, 4};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKthLargest(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,2,3,1,2,4,5,5,6], k = 4");
        try {
            int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.findKthLargest(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
