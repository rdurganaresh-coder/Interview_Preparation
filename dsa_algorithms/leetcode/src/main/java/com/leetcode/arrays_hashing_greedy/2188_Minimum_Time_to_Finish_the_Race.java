package com.leetcode.arrays_hashing_greedy;

class Solution2188 {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        final int inf = 1 << 30;
        int[] cost = new int[18];
        Arrays.fill(cost, inf);
        for (int[] e : tires) {
            int f = e[0], r = e[1];
            int s = 0, t = f;
            for (int i = 1; t <= changeTime + f; ++i) {
                s += t;
                cost[i] = Math.min(cost[i], s);
                t *= r;
            }
        }
        int[] f = new int[numLaps + 1];
        Arrays.fill(f, inf);
        f[0] = -changeTime;
        for (int i = 1; i <= numLaps; ++i) {
            for (int j = 1; j < Math.min(18, i + 1); ++j) {
                f[i] = Math.min(f[i], f[i - j] + cost[j]);
            }
            f[i] += changeTime;
        }
        return f[numLaps];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2188 _tcSol = new Solution2188();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tires = [[2,3],[3,4]], changeTime = 5, numLaps = 4");
        try {
            int[][] tires = new int[][]{new int[]{2, 3}, new int[]{3, 4}};
            int changeTime = 5;
            int numLaps = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumFinishTime(tires, changeTime, numLaps)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tires = [[1,10],[2,2],[3,4]], changeTime = 6, numLaps = 5");
        try {
            int[][] tires = new int[][]{new int[]{1, 10}, new int[]{2, 2}, new int[]{3, 4}};
            int changeTime = 6;
            int numLaps = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumFinishTime(tires, changeTime, numLaps)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "25");
        System.out.println();
    }
}