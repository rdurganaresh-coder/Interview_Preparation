package com.leetcode.dynamic_programming;

class Solution2593 {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> q
            = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; ++i) {
            q.offer(new int[] {nums[i], i});
        }
        long ans = 0;
        while (!q.isEmpty()) {
            var p = q.poll();
            ans += p[0];
            vis[p[1]] = true;
            for (int j : List.of(p[1] - 1, p[1] + 1)) {
                if (j >= 0 && j < n) {
                    vis[j] = true;
                }
            }
            while (!q.isEmpty() && vis[q.peek()[1]]) {
                q.poll();
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
        Solution2593 _tcSol = new Solution2593();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,3,4,5,2]");
        try {
            int[] nums = new int[]{2, 1, 3, 4, 5, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,5,1,3,2]");
        try {
            int[] nums = new int[]{2, 3, 5, 1, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}