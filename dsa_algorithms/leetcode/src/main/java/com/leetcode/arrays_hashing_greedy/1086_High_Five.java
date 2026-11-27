package com.leetcode.arrays_hashing_greedy;

class Solution1086 {
    public int[][] highFive(int[][] items) {
        int size = 0;
        PriorityQueue[] s = new PriorityQueue[101];
        int n = 5;
        for (int[] item : items) {
            int i = item[0], score = item[1];
            if (s[i] == null) {
                ++size;
                s[i] = new PriorityQueue<>(n);
            }
            s[i].offer(score);
            if (s[i].size() > n) {
                s[i].poll();
            }
        }
        int[][] res = new int[size][2];
        int j = 0;
        for (int i = 0; i < 101; ++i) {
            if (s[i] == null) {
                continue;
            }
            int avg = sum(s[i]) / n;
            res[j][0] = i;
            res[j++][1] = avg;
        }
        return res;
    }

    private int sum(PriorityQueue<Integer> q) {
        int s = 0;
        while (!q.isEmpty()) {
            s += q.poll();
        }
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1086 _tcSol = new Solution1086();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]");
        try {
            int[][] items = new int[][]{new int[]{1, 91}, new int[]{1, 92}, new int[]{2, 93}, new int[]{2, 97}, new int[]{1, 60}, new int[]{2, 77}, new int[]{1, 65}, new int[]{1, 87}, new int[]{1, 100}, new int[]{2, 100}, new int[]{2, 76}};
            System.out.println("  Output  : " + _tcShow(_tcSol.highFive(items)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,87],[2,88]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]");
        try {
            int[][] items = new int[][]{new int[]{1, 100}, new int[]{7, 100}, new int[]{1, 100}, new int[]{7, 100}, new int[]{1, 100}, new int[]{7, 100}, new int[]{1, 100}, new int[]{7, 100}, new int[]{1, 100}, new int[]{7, 100}};
            System.out.println("  Output  : " + _tcShow(_tcSol.highFive(items)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,100],[7,100]]");
        System.out.println();
    }
}