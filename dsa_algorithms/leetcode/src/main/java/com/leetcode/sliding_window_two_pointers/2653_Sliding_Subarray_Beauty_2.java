package com.leetcode.sliding_window_two_pointers;

class MedianFinder2653_2 {
    private PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private Map<Integer, Integer> delayed = new HashMap<>();
    private int smallSize;
    private int largeSize;
    private int x;

    public MedianFinder2653_2(int x) {
        this.x = x;
    }

    public void addNum(int num) {
        if (smallSize < x || num <= small.peek()) {
            small.offer(num);
            ++smallSize;
        } else {
            large.offer(num);
            ++largeSize;
        }
        rebalance();
    }

    public int find() {
        return smallSize == x ? small.peek() : 0;
    }

    public void removeNum(int num) {
        delayed.merge(num, 1, Integer::sum);
        if (num <= small.peek()) {
            --smallSize;
            if (num == small.peek()) {
                prune(small);
            }
        } else {
            --largeSize;
            if (num == large.peek()) {
                prune(large);
            }
        }
        rebalance();
    }

    private void prune(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty() && delayed.containsKey(pq.peek())) {
            if (delayed.merge(pq.peek(), -1, Integer::sum) == 0) {
                delayed.remove(pq.peek());
            }
            pq.poll();
        }
    }

    private void rebalance() {
        if (smallSize > x) {
            large.offer(small.poll());
            --smallSize;
            ++largeSize;
            prune(small);
        } else if (smallSize < x && largeSize > 0) {
            small.offer(large.poll());
            --largeSize;
            ++smallSize;
            prune(large);
        }
    }
}

class Solution2653_2 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        MedianFinder2653_2 finder = new MedianFinder2653_2(x);
        for (int i = 0; i < k; ++i) {
            if (nums[i] < 0) {
                finder.addNum(nums[i]);
            }
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        ans[0] = finder.find();
        for (int i = k; i < n; ++i) {
            if (nums[i] < 0) {
                finder.addNum(nums[i]);
            }
            if (nums[i - k] < 0) {
                finder.removeNum(nums[i - k]);
            }
            ans[i - k + 1] = finder.find();
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2653_2 _tcSol = new Solution2653_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,-1,-3,-2,3], k = 3, x = 2");
        try {
            int[] nums = new int[]{1, -1, -3, -2, 3};
            int k = 3;
            int x = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getSubarrayBeauty(nums, k, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-2,-2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,-2,-3,-4,-5], k = 2, x = 2");
        try {
            int[] nums = new int[]{-1, -2, -3, -4, -5};
            int k = 2;
            int x = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getSubarrayBeauty(nums, k, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-2,-3,-4]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-3,1,2,-3,0,-3], k = 2, x = 1");
        try {
            int[] nums = new int[]{-3, 1, 2, -3, 0, -3};
            int k = 2;
            int x = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.getSubarrayBeauty(nums, k, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-3,0,-3,-3,-3]");
        System.out.println();
    }
}