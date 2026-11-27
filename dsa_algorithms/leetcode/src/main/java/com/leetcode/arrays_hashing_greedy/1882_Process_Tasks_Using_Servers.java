package com.leetcode.arrays_hashing_greedy;

class Solution1882 {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        PriorityQueue<int[]> idle = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[2], b[2]);
        });
        for (int i = 0; i < n; i++) {
            idle.offer(new int[] {servers[i], i});
        }
        int m = tasks.length;
        int[] ans = new int[m];
        for (int j = 0; j < m; ++j) {
            int t = tasks[j];
            while (!busy.isEmpty() && busy.peek()[0] <= j) {
                long[] p = busy.poll();
                idle.offer(new int[] {(int) p[1], (int) p[2]});
            }
            if (!idle.isEmpty()) {
                int i = idle.poll()[1];
                ans[j] = i;
                busy.offer(new long[] {(long) j + t, servers[i], i});
            } else {
                long[] p = busy.poll();
                int i = (int) p[2];
                ans[j] = i;
                busy.offer(new long[] {p[0] + t, p[1], i});
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
        Solution1882 _tcSol = new Solution1882();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "servers = [3,3,2], tasks = [1,2,3,2,1,2]");
        try {
            int[] servers = new int[]{3, 3, 2};
            int[] tasks = new int[]{1, 2, 3, 2, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.assignTasks(servers, tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2,0,2,1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "servers = [5,1,4,3,2], tasks = [2,1,2,4,5,2,1]");
        try {
            int[] servers = new int[]{5, 1, 4, 3, 2};
            int[] tasks = new int[]{2, 1, 2, 4, 5, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.assignTasks(servers, tasks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,4,1,4,1,3,2]");
        System.out.println();
    }
}
