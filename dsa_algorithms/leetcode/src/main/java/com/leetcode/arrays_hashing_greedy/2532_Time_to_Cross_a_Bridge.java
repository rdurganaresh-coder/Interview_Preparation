package com.leetcode.arrays_hashing_greedy;

class Solution2532 {
    public int findCrossingTime(int n, int k, int[][] time) {
        int[][] t = new int[k][5];
        for (int i = 0; i < k; ++i) {
            int[] x = time[i];
            t[i] = new int[] {x[0], x[1], x[2], x[3], i};
        }
        Arrays.sort(t, (a, b) -> {
            int x = a[0] + a[2], y = b[0] + b[2];
            return x == y ? a[4] - b[4] : x - y;
        });
        int cur = 0;
        PriorityQueue<Integer> waitInLeft = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> waitInRight = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<int[]> workInLeft = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> workInRight = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; ++i) {
            waitInLeft.offer(i);
        }
        while (true) {
            while (!workInLeft.isEmpty()) {
                int[] p = workInLeft.peek();
                if (p[0] > cur) {
                    break;
                }
                waitInLeft.offer(workInLeft.poll()[1]);
            }
            while (!workInRight.isEmpty()) {
                int[] p = workInRight.peek();
                if (p[0] > cur) {
                    break;
                }
                waitInRight.offer(workInRight.poll()[1]);
            }
            boolean leftToGo = n > 0 && !waitInLeft.isEmpty();
            boolean rightToGo = !waitInRight.isEmpty();
            if (!leftToGo && !rightToGo) {
                int nxt = 1 << 30;
                if (!workInLeft.isEmpty()) {
                    nxt = Math.min(nxt, workInLeft.peek()[0]);
                }
                if (!workInRight.isEmpty()) {
                    nxt = Math.min(nxt, workInRight.peek()[0]);
                }
                cur = nxt;
                continue;
            }
            if (rightToGo) {
                int i = waitInRight.poll();
                cur += t[i][2];
                if (n == 0 && waitInRight.isEmpty() && workInRight.isEmpty()) {
                    return cur;
                }
                workInLeft.offer(new int[] {cur + t[i][3], i});
            } else {
                int i = waitInLeft.poll();
                cur += t[i][0];
                --n;
                workInRight.offer(new int[] {cur + t[i][1], i});
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2532 _tcSol = new Solution2532();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1, k = 3, time = [[1,1,2,1],[1,1,3,1],[1,1,4,1]]");
        try {
            int n = 1;
            int k = 3;
            int[][] time = new int[][]{new int[]{1, 1, 2, 1}, new int[]{1, 1, 3, 1}, new int[]{1, 1, 4, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findCrossingTime(n, k, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, k = 2, time = [[1,5,1,8],[10,10,10,10]]");
        try {
            int n = 3;
            int k = 2;
            int[][] time = new int[][]{new int[]{1, 5, 1, 8}, new int[]{10, 10, 10, 10}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findCrossingTime(n, k, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "37");
        System.out.println();
    }
}