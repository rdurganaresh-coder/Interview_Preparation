package com.leetcode.arrays_hashing_greedy;

class Solution3362 {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = nums.length;
        int[] d = new int[n + 1];
        int s = 0, j = 0;
        for (int i = 0; i < n; i++) {
            s += d[i];
            while (j < queries.length && queries[j][0] <= i) {
                pq.offer(queries[j][1]);
                j++;
            }
            while (s < nums[i] && !pq.isEmpty() && pq.peek() >= i) {
                s++;
                d[pq.poll() + 1]--;
            }
            if (s < nums[i]) {
                return -1;
            }
        }
        return pq.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3362 _tcSol = new Solution3362();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,0,2], queries = [[0,2],[0,2],[1,1]]");
        try {
            int[] nums = new int[]{2, 0, 2};
            int[][] queries = new int[][]{new int[]{0, 2}, new int[]{0, 2}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRemoval(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1,1], queries = [[1,3],[0,2],[1,3],[1,2]]");
        try {
            int[] nums = new int[]{1, 1, 1, 1};
            int[][] queries = new int[][]{new int[]{1, 3}, new int[]{0, 2}, new int[]{1, 3}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRemoval(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4], queries = [[0,3]]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            int[][] queries = new int[][]{new int[]{0, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRemoval(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
