package com.leetcode.arrays_hashing_greedy;

class Solution2402 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        PriorityQueue<Integer> idle = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            idle.offer(i);
        }
        int[] cnt = new int[n];
        for (var v : meetings) {
            int s = v[0], e = v[1];
            while (!busy.isEmpty() && busy.peek()[0] <= s) {
                idle.offer((int) busy.poll()[1]);
            }
            int i = 0;
            if (!idle.isEmpty()) {
                i = idle.poll();
                busy.offer(new long[] {e, i});
            } else {
                var x = busy.poll();
                i = (int) x[1];
                busy.offer(new long[] {x[0] + e - s, i});
            }
            ++cnt[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (cnt[ans] < cnt[i]) {
                ans = i;
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
        Solution2402 _tcSol = new Solution2402();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]");
        try {
            int n = 2;
            int[][] meetings = new int[][]{new int[]{0, 10}, new int[]{1, 5}, new int[]{2, 7}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostBooked(n, meetings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]");
        try {
            int n = 3;
            int[][] meetings = new int[][]{new int[]{1, 20}, new int[]{2, 10}, new int[]{3, 5}, new int[]{4, 9}, new int[]{6, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostBooked(n, meetings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}