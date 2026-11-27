package com.leetcode.arrays_hashing_greedy;

class Solution3092 {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        Map<Integer, Long> cnt = new HashMap<>();
        Map<Long, Integer> lazy = new HashMap<>();
        int n = nums.length;
        long[] ans = new long[n];
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; ++i) {
            int x = nums[i], f = freq[i];
            lazy.merge(cnt.getOrDefault(x, 0L), 1, Integer::sum);
            cnt.merge(x, (long) f, Long::sum);
            pq.add(cnt.get(x));
            while (!pq.isEmpty() && lazy.getOrDefault(pq.peek(), 0) > 0) {
                lazy.merge(pq.poll(), -1, Integer::sum);
            }
            ans[i] = pq.isEmpty() ? 0 : pq.peek();
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3092 _tcSol = new Solution3092();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,2,1], freq = [3,2,-3,1]");
        try {
            int[] nums = new int[]{2, 3, 2, 1};
            int[] freq = new int[]{3, 2, -3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostFrequentIDs(nums, freq)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3,2,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,5,3], freq = [2,-2,1]");
        try {
            int[] nums = new int[]{5, 5, 3};
            int[] freq = new int[]{2, -2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostFrequentIDs(nums, freq)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,0,1]");
        System.out.println();
    }
}