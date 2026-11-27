package com.leetcode.arrays_hashing_greedy;

class Solution0502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        PriorityQueue<int[]> q1 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; ++i) {
            q1.offer(new int[] {capital[i], profits[i]});
        }
        PriorityQueue<Integer> q2 = new PriorityQueue<>((a, b) -> b - a);
        while (k-- > 0) {
            while (!q1.isEmpty() && q1.peek()[0] <= w) {
                q2.offer(q1.poll()[1]);
            }
            if (q2.isEmpty()) {
                break;
            }
            w += q2.poll();
        }
        return w;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0502 _tcSol = new Solution0502();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]");
        try {
            int k = 2;
            int w = 0;
            int[] profits = new int[]{1, 2, 3};
            int[] capital = new int[]{0, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaximizedCapital(k, w, profits, capital)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]");
        try {
            int k = 3;
            int w = 0;
            int[] profits = new int[]{1, 2, 3};
            int[] capital = new int[]{0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaximizedCapital(k, w, profits, capital)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}