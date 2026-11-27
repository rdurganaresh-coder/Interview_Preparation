package com.leetcode.arrays_hashing_greedy;

class Solution3462 {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = grid.length;
        for (int i = 0; i < n; ++i) {
            int[] nums = grid[i];
            int limit = limits[i];
            Arrays.sort(nums);
            for (int j = 0; j < limit; ++j) {
                pq.offer(nums[nums.length - j - 1]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        long ans = 0;
        for (int x : pq) {
            ans += x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3462 _tcSol = new Solution3462();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "grid = [[1,2],[3,4]], limits = [1,2], k = 2");
        try {
            int[][] grid = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
            int[] limits = new int[]{1, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(grid, limits, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "grid = [[5,3,7],[8,2,6]], limits = [2,2], k = 3");
        try {
            int[][] grid = new int[][]{new int[]{5, 3, 7}, new int[]{8, 2, 6}};
            int[] limits = new int[]{2, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(grid, limits, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();
    }
}
