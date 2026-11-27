package com.leetcode.arrays_hashing_greedy;

class Solution1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = days.length;
        int ans = 0, i = 0;
        while (i < n || !q.isEmpty()) {
            if (i < n && apples[i] > 0) {
                q.offer(new int[] {i + days[i] - 1, apples[i]});
            }
            while (!q.isEmpty() && q.peek()[0] < i) {
                q.poll();
            }
            if (!q.isEmpty()) {
                var p = q.poll();
                ++ans;
                if (--p[1] > 0 && p[0] > i) {
                    q.offer(p);
                }
            }
            ++i;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1705 _tcSol = new Solution1705();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "apples = [1,2,3,5,2], days = [3,2,1,4,2]");
        try {
            int[] apples = new int[]{1, 2, 3, 5, 2};
            int[] days = new int[]{3, 2, 1, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.eatenApples(apples, days)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]");
        try {
            int[] apples = new int[]{3, 0, 0, 0, 0, 2};
            int[] days = new int[]{3, 0, 0, 0, 0, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.eatenApples(apples, days)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}