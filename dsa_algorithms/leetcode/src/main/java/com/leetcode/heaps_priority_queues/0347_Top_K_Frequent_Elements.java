package com.leetcode.heaps_priority_queues;

class Solution0347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq
            = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (var e : cnt.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.stream().mapToInt(Map.Entry::getKey).toArray();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0347 _tcSol = new Solution0347();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,1,2,2,3], k = 2");
        try {
            int[] nums = new int[]{1, 1, 1, 2, 2, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.topKFrequent(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1], k = 1");
        try {
            int[] nums = new int[]{1};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.topKFrequent(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,1,2,1,2,3,1,3,2], k = 2");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.topKFrequent(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();
    }
}
