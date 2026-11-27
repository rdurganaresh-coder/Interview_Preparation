package com.leetcode.arrays_hashing_greedy;

class Solution2071 {
    private int[] tasks;
    private int[] workers;
    private int strength;
    private int pills;
    private int m;
    private int n;

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        this.tasks = tasks;
        this.workers = workers;
        this.strength = strength;
        this.pills = pills;
        n = tasks.length;
        m = workers.length;
        int left = 0, right = Math.min(m, n);
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int x) {
        int i = 0;
        Deque<Integer> q = new ArrayDeque<>();
        int p = pills;
        for (int j = m - x; j < m; ++j) {
            while (i < x && tasks[i] <= workers[j] + strength) {
                q.offer(tasks[i++]);
            }
            if (q.isEmpty()) {
                return false;
            }
            if (q.peekFirst() <= workers[j]) {
                q.pollFirst();
            } else if (p == 0) {
                return false;
            } else {
                --p;
                q.pollLast();
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2071 _tcSol = new Solution2071();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tasks = [3,2,1], workers = [0,3,3], pills = 1, strength = 1");
        try {
            int[] tasks = new int[]{3, 2, 1};
            int[] workers = new int[]{0, 3, 3};
            int pills = 1;
            int strength = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTaskAssign(tasks, workers, pills, strength)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tasks = [5,4], workers = [0,0,0], pills = 1, strength = 5");
        try {
            int[] tasks = new int[]{5, 4};
            int[] workers = new int[]{0, 0, 0};
            int pills = 1;
            int strength = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTaskAssign(tasks, workers, pills, strength)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "tasks = [10,15,30], workers = [0,10,10,10,10], pills = 3, strength = 10");
        try {
            int[] tasks = new int[]{10, 15, 30};
            int[] workers = new int[]{0, 10, 10, 10, 10};
            int pills = 3;
            int strength = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTaskAssign(tasks, workers, pills, strength)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}