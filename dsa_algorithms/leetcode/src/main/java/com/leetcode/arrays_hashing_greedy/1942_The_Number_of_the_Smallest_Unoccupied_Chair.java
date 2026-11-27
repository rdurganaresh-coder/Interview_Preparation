package com.leetcode.arrays_hashing_greedy;

class Solution1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        PriorityQueue<Integer> idle = new PriorityQueue<>();
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; ++i) {
            times[i] = new int[] {times[i][0], times[i][1], i};
            idle.offer(i);
        }
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
        for (var e : times) {
            int arrival = e[0], leaving = e[1], i = e[2];
            while (!busy.isEmpty() && busy.peek()[0] <= arrival) {
                idle.offer(busy.poll()[1]);
            }
            int j = idle.poll();
            if (i == targetFriend) {
                return j;
            }
            busy.offer(new int[] {leaving, j});
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1942 _tcSol = new Solution1942();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "times = [[1,4],[2,3],[4,6]], targetFriend = 1");
        try {
            int[][] times = new int[][]{new int[]{1, 4}, new int[]{2, 3}, new int[]{4, 6}};
            int targetFriend = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestChair(times, targetFriend)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "times = [[3,10],[1,5],[2,6]], targetFriend = 0");
        try {
            int[][] times = new int[][]{new int[]{3, 10}, new int[]{1, 5}, new int[]{2, 6}};
            int targetFriend = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestChair(times, targetFriend)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
